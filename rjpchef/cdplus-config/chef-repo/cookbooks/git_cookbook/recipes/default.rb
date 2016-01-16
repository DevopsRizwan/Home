#
# Cookbook Name:: git_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#git_version=node['git']['version'].to_s
#git_package=git-"#{git_version}-#{node['git']['version']['release']}"


package 'git' do
	#version "1.7.1-3.el6_4.1"
	version node['git']['version']
	action :install
end
