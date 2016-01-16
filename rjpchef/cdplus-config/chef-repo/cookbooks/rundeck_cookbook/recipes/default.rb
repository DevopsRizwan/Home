#
# Cookbook Name:: maven_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute

case node['platform_family']
when 'rhel'

	remote_file "#{Chef::Config['file_cache_path']}/rundeck-config-#{node['rundeck']['rpm_version']}.noarch.rpm" do
		owner 'root'
		group 'root'
		mode 00644
		source node['rundeck']['rpm_cfg_url']
		checksum node['rundeck']['rpm_cfg_checksum']
		action :create
	end

	remote_file "#{Chef::Config['file_cache_path']}/rundeck-#{node['rundeck']['rpm_version']}.noarch.rpm" do
		owner 'root'
		group 'root'
		mode 00644
		source node['rundeck']['rpm_url']
		checksum node['rundeck']['rpm_checksum']
		action :create
	end

	execute "install-rundeck-#{node['rundeck']['rpm_version']}" do
		command "yum -y localinstall #{Chef::Config['file_cache_path']}/rundeck-#{node['rundeck']['rpm_version']}.noarch.rpm #{Chef::Config['file_cache_path']}/rundeck-config-#{node['rundeck']['rpm_version']}.noarch.rpm"
		action :run
		not_if "rpm -q rundeck | grep #{node['rundeck']['rpm_version']}"
	end

   Array(node['rundeck']['config_files']).each do |f|
     template "/etc/rundeck/#{f}" do
       source "#{f}.erb"
       owner 'rundeck'
       group 'rundeck'
       mode 00644
     end
   end

#Array(node['rundeck']['dir_path']).each do |path|
#   bash 'change-ownership' do
#        user node['rundeck']['super_user']
#        code <<-EOH
#        chown -R "#{node['rundeck']['group']}":"#{node['rundeck']['user']}" "#{path}"
#        EOH
#   end
#end
end
