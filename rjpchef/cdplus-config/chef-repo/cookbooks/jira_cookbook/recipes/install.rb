#
# Cookbook Name:: jira_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
include_recipe 'java7_cookbook::default'

template "opt/atlassian-jira-response.varfile" do
  source 'response.varfile.erb'
  owner 'root'
  group 'root'
  mode '0644'
end

remote_file "opt/#{node['jira']['binary']}" do
  source node['jira']['url']
  mode "755"
  action :create
end

execute "Installing Jira" do
  command "sh /opt/#{node['jira']['binary']} -q -varfile atlassian-jira-response.varfile"
  creates node['jira']['install_path']
end
#
