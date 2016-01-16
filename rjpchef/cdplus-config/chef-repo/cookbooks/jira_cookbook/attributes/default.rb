default['java']['jdk_version'] = '7'

default['jira']['homedir'] = '/var/jira-home'
default['jira']['version'] = '6.4.3'
default['jira']['parentdir'] = '/opt'
default['jira']['bit'] = 'x64'
 
default['jira']['binary'] = "atlassian-jira-#{node['jira']['version']}-#{node['jira']['bit']}.bin"
default['jira']['url'] = "http://www.atlassian.com/software/jira/downloads/binary/#{node['jira']['binary']}"

default['jira']['home_path']      = '/var/atlassian/application-data/jira'
default['jira']['install_path']   = '/opt/atlassian/jira'
default['jira']['tomcat']['port']     = '8090'
default['jira']['control']['port']     = '8095'

default['mysql']['password'] = "root"
default['mysql']['create_db_file']['path'] = "/opt/atlassian/jira/database/mysql/create_database.sql"

default['mysql']['connector']['file']  = "mysql-connector-java-5.1.35"
default['mysql']['connector']['path'] = "#{node['jira']['install_path']}/lib/"
default['mysql']['connector']['url']  = "http://dev.mysql.com/get/Downloads/Connector-J/#{node['mysql']['connector']['file']}.zip"
