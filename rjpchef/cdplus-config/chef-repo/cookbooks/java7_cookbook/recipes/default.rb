#
# Cookbook Name:: java7_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
jdk_version = node['java']['jdk_version'].to_i
java_home = node['java']['java_home']

package "java-1.#{jdk_version}.0-openjdk-devel" do
	action :install
end

file "/etc/profile.d/jdk.sh" do
  content <<-EOS
    export JAVA_HOME=#{node['java']['java_home']}
  EOS
  mode 0755
end

