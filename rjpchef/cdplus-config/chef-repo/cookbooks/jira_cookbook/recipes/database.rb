

#include mysql receipe
#include_recipe 'mysql_cookbook::default'

#create directory to put sql file
directory "/opt/atlassian/jira/database/mysql" do 
	recursive true
	action :create
	mode 0644
	group "root"
	owner "root"
end
#create sql file at metioned location
cookbook_file "create_database.sql" do
  path node['mysql']['create_db_file']['path']
  owner "root"
  group "root"
  mode "0600"
  action :create
end
#execute sql command
execute "mysql-createdb-grantrights" do
	command "/usr/bin/mysql -u root -p#{node['mysql']['password']} < #{node['mysql']['create_db_file']['path']}"
end


#add mysql driver jar to jira lib directory
remote_file "/opt/#{node['mysql']['connector']['file']}.zip" do
  source node['mysql']['connector']['url']
  mode "755"
  action :create
end

execute "unzip -o /opt/#{node['mysql']['connector']['file']}.zip -d /opt/ && cp /opt/#{node['mysql']['connector']['file']}/#{node['mysql']['connector']['file']}-bin.jar #{node['mysql']['connector']['path']}" do
end

#template "#{node['jira']['homedir']}/dbconfig.xml" do
#  source 'dbconfig.xml.erb'
#  owner 'jira'
#  group 'jira'
#  mode 00600
#  action :create  
#end
#irestart the jira
execute "restart jira" do
	command "sudo service jira stop && sudo service jira start"
end
