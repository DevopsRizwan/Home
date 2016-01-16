#
# Cookbook Name:: mysql_cookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#commenting the belwo block as it does not works well for setting the root user and passwd
=begin
# =begin and =end are mulyiline comments in ruby
bash 'check_installation' do
  code <<-EOH
  var=`rpm -qa | grep mysql`
  if [[ -z "$var" ]]; then
   echo mysql is not installed
   notInstalled=true
  else
   echo mysql is installed
   notInstalled=false
  fi
  EOH
end
=end

#if "#{notInstalled}"
package 'mysql-server' do
 version node['mysql']['version']
 action :install
end

package 'mysql' do
  action :install
  version node['mysql']['version']
end

service 'mysqld' do
  supports status: true, restart: true, reload: true
  action  [:enable, :start]
end

template '/etc/my.cnf' do
   source   'mycnf.erb'
   mode     '0755'
   notifies :restart, 'service[mysqld]', :immediately
end

=begin
execute "set password" do
  command "sudo mysqladmin -u root password root"
end

execute 'mysql-server-installed' do
  command "echo mysql-server installed sucessfully!!"
end

else
execute 'mysql-server-already-instaled' do
  command "echo mysql-server already installed!!!"
end

end
=end
