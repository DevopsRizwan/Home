#
# Cookbook Name:: jenkins_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
  remote_file "/tmp/#{node['jenkins']['master']['rpm']}" do
	source "#{node['jenkins']['master']['url']}"
	mode 0644
	not_if { ::File.exists?("/tmp/#{node['jenkins']['master']['rpm']}") }
  end

  execute "rpm -qa | grep jenkins || rpm -Uvh /tmp/#{node['jenkins']['master']['rpm']}"

  template '/etc/sysconfig/jenkins' do
    source   'jenkins-config-rhel.erb'
    mode     '0644'
    notifies :restart, 'service[jenkins]', :immediately
  end

 template '/etc/profile.d/jenkinsrc.sh' do
    source 'jenkinsrc.erb'
    mode   '0755'
  end

service 'jenkins' do
  supports status: true, restart: true, reload: true
  action  [:enable, :start]
end

Array(node['jenkins']['master']['dir_path']).each do |path|
   bash "changeownership" do
        user node['jenkins']['master']['super_user']
        code <<-EOH
        chown -R "#{node['jenkins']['master']['group']}":"#{node['jenkins']['master']['user']}" "#{path}"
        EOH
   end
end

#Followign code installs plugins that are mentioned in the array in the attributes file
Array(node['jenkins']['master']['plugins']).each do |plugin|
    plugin, version= plugin.split(/:\s/, 2)
    jenkins_plugin plugin do
	version version
    end
end

Array(node['jenkins']['master']['config_files']).each do |f|
   template "/var/lib/jenkins/#{f}" do
    	source "#{f}.erb"
    	mode 0755
	notifies :restart, 'service[jenkins]', :delayed
  end
end

