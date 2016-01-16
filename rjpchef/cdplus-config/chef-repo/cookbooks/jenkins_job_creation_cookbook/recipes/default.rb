#
# Cookbook Name:: jenkins_job_creation_cookbook1
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

directory "/var/lib/jenkins/config_dir" do
    owner node['jenkins']['master']['user']
    group node['jenkins']['master']['group']
    mode '0775'
    action :create
    recursive true
end

Array(node['jenkins']['master']['job_config_files']).each do |file|
   template "/var/lib/jenkins/config_dir/#{file}" do
        source "#{file}.erb"
        mode 0755
  end
end

Array(node['jenkins']['master']['job_dir']).each do |job_dir|
   execute "sh /var/lib/jenkins/config_dir/job_creation.sh #{job_dir} #{node['jenkins']['master']['path_to_default_dir']} #{node['jenkins']['master']['endpoint']}"
end

execute "sudo service jenkins restart"

