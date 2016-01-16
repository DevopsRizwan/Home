#
# Cookbook Name:: sonar_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
package "unzip" do
	action :install
end

remote_file "/opt/sonarqube-#{node['sonar']['version']}.zip" do
	source "#{node['sonar']['mirror']}/sonarqube-#{node['sonar']['version']}.zip"
  	mode "0644"
	action :create
	#checksum "#{node['sonar']['checksum']}"
  	#not_if { ::File.exists?("/opt/sonarqube-#{node['sonar']['version']}.zip") }
end

execute "unzip -o /opt/sonarqube-#{node['sonar']['version']}.zip -d /opt/" do
	#not_if { ::File.directory?("/opt/sonarqube-#{node['sonar']['version']}/") }
end

link "/opt/sonar" do
	to "/opt/sonarqube-#{node['sonar']['version']}"
end

service "mysqld" do 
	action :start
end

directory "/opt/sonar/extras/database/mysql" do 
	recursive true
	action :create
	mode 0644
	group "root"
	owner "root"
end

cookbook_file "create_mysql_db.sql" do
  path node['mysql']['create_db_file']['path']
  owner "root"
  group "root"
  mode "0600"
  action :create
end

execute "mysql-createdb-grantrights" do
	command "/usr/bin/mysql -u root -p#{node['mysql']['password']} < #{node['mysql']['create_db_file']['path']}"
end

template "sonar.properties" do
  path "/opt/sonar/conf/sonar.properties"
  source "sonar.properties.erb"
  owner "root"
  group "root"
  mode 0644
end

template "/etc/init.d/sonar" do
	source "init-rhel.erb"
	owner "root"
	group "root"
	mode "0755"
end

execute "init-rhel" do
	user "root"
	group "root"
	command "chkconfig --add sonar"
	action :run
end

execute "sudo service sonar restart"
