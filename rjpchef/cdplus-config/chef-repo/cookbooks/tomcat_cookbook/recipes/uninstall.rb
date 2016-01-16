#
# Cookbook Name:: tomcat_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
package node['tomcat']['deploy_manager_packages'] do
    action :remove
end

package node['tomcat']['webapp_package'] do
    action :remove
end

package node['tomcat']['package'] do
    action :remove
end


