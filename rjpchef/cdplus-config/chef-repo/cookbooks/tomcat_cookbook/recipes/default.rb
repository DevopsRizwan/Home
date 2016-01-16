#
# Cookbook Name:: tomcat_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
package node['tomcat']['package'] do
    action :install
end

package node['tomcat']['webapp_package'] do
    action :install
end

package node['tomcat']['deploy_manager_packages'] do
    action :install
end

service node['tomcat']['package'] do
  supports status: true, restart: true, reload: true
  action  [:enable, :start]
end
