#
# Cookbook Name:: apache_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
package "httpd" do
action :install
end


####

service "httpd" do
action [:start, :enable]
end
#######
cookbook_file "var/www/html/index.html" do
source "index.html"
mode "0644"
end
