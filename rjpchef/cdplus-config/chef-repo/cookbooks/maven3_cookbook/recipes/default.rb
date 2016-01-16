#
# Cookbook Name:: maven3_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute

file_name="/tmp/apache-maven-#{node['maven']['3']['version']}-bin.tar.gz"

remote_file "#{file_name}" do
  source node['maven']['3']['url']
end

directory '/usr/local/apache-maven' do
	action :create
end
bash 'untar-maven-archive' do
  cwd '/usr/local/apache-maven/'
  code <<-EOH
     tar xvzf #{file_name}
  EOH
end

link "maven-soft-link" do
	target_file '/usr/local/maven'
	to "/usr/local/apache-maven/apache-maven-#{node['maven']['3']['version']}"
	
end

template '/etc/profile.d/mavenrc.sh' do
   source 'mavenrc.erb'
   mode   '0755'
end

template '/usr/local/maven/conf/settings.xml' do
   source 'settings.xml.erb'
   mode   '0755'
end

