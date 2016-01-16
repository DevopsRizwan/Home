#
# Cookbook Name:: javaAlternatives_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
#
jdk_version = node['java']['jdk_version'].to_i
java_home = node['java']['java_home']

package "java-1.#{jdk_version}.0-openjdk-devel" do
action :install
end
 
execute 'remoteScript' do
command "$HOME/setjava.sh \\#{jdk_version}"
action :run
end
