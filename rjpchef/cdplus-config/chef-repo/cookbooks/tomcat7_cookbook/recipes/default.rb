#
# Cookbook Name:: tomcat7_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
tomcat_tar = "#{Chef::Config[:file_cache_path]}/tomcat-#{node['tomcat7']['version']}.tar.gz"
#tomcat_daemon_tar = "#{node['tomcat7']['daemon-native-src']['dir']}/bin/#{node['tomcat7']['daemon-native-src']['tar']}"
group node['tomcat7']['user'] do
  action :create
end

user node['tomcat7']['user'] do
  gid node['tomcat7']['user']
  shell '/bin/bash'
  #home '/home/tomcat'
  system false 
  action :create
end


#### Commenting out below line since using a variable instead looks more neat - Tapas
#remote_file "#{Chef::Config[:file_cache_path]}/tomcat-#{node['tomcat7']['version']}.tar.gz" do
remote_file tomcat_tar do
  source node['tomcat7']['url']
  action :create_if_missing
  ### Checksum validation needs t obe implementred. Currently this is failing. I need to explore more on this. - Tapas
  #checksum node['tomcat7']['sha1sum']
end

directory node['tomcat7']['install']['dir'] do
   action :create
   mode 0755
   recursive true
   owner "#{node['tomcat7']['user']}" 
   group "#{node['tomcat7']['user']}"
end

bash 'untarring-tomcat7' do
   user "#{node['tomcat7']['user']}" 
   group "#{node['tomcat7']['user']}"
   cwd "#{node['tomcat7']['install']['dir']}"
   code <<-EOH
	tar xvfv #{tomcat_tar} -C #{node['tomcat7']['install']['dir']}
   EOH
#   not_if { ::File.exists?(node['tomcat7']['install']['dir']) }
end

#template '/etc/profile.d/tomcat7.sh' do
#   source 'tomcat7.erb'
#   mode   '0755'
#end

### Setting tomcat7 as a daemon
#bash 'untarring-tomcat7-daemon-tar' do
#   #user "#{node['tomcat7']['user']}" 
#   #group "#{node['tomcat7']['user']}"
#   cwd "#{node['tomcat7']['daemon-native-src']['dir']}/bin/"
#   code <<-EOH
#	tar xvfv #{tomcat_daemon_tar} -C #{node['tomcat7']['daemon-native-src']['dir']}/bin/
#   EOH
#   not_if { ::File.exists?("#{node['tomcat7']['daemon-native-src']['dir']})/bin/commons-daemon-1.0.15-native-src") }
#end


### Executing commands to run tomcat7 as a daemon
#bash 'configuring-tomcat7-daemon' do
#   #user "#{node['tomcat7']['user']}" 
#   #group "#{node['tomcat7']['user']}"
#   cwd "#{node['tomcat7']['daemon-native-src']['dir']}"
#   code <<-EOH
#	tar xvfv #{tomcat_daemon_tar} -C #{node['tomcat7']['daemon-native-src']['dir']}/bin/
#   EOH
#end

    template "/etc/init.d/tomcat7" do
		source "init-rhel.erb"
		owner "root"
		group "root"
		mode "0755"
    end
    execute "init-rhel" do
		user "root"
		group "root"
		command "chkconfig --add tomcat7"
		action :run
    end

# Start service
#service 'tomcat7' do
 # supports restart: true, reload: true
 # action  [:enable, :start]
#end

execute "sudo service tomcat7 restart" 
# service 'tomcat7' do
 #    service_name 'tomcat7'
  #   action :start 

#end

