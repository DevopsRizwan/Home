default['rundeck']['rpm_version']       = '2.5.0-1.6.GA'
default['rundeck']['rpm_url']           = "http://download.rundeck.org/rpm/rundeck-#{node['rundeck']['rpm_version']}.noarch.rpm"
default['rundeck']['rpm_cfg_url']       = "http://download.rundeck.org/rpm/rundeck-config-#{node['rundeck']['rpm_version']}.noarch.rpm"
default['rundeck']['rpm_checksum']      = '24bf69f9ce2aeab9da789193b488160c4b0eb771fe9cc82c7b53fef8ddf653dc'
default['rundeck']['rpm_cfg_checksum']  = '879005da4c3292fde4a65433287a0ff301478e7077818b2a42030b4ede4dc0d2'

default['rundeck']['host']['name'] = 'jenkins-rundeck.cognizant.com'
default['rundeck']['port'] = '4440'
default['rundeck']['host']['ip'] = '54.152.165.4'
default['rundeck']['admin']['username'] = 'admin'
default['rundeck']['admin']['password'] = 'admin'
default['rundeck']['framework']['username'] = 'admin'
default['rundeck']['framework']['password'] = 'admin'
default['rundeck']['base_dir']= '/etc/rundeck'

config_files = %w(framework.properties realm.properties rundeck-config.properties) if platform?('redhat')
default['rundeck']['config_files'] = config_files

#default['rundeck']['user'] = 'rundeck'
#default['rundeck']['group'] = 'rundeck'
#default['rundeck']['super_user'] = 'root'
#
rundeck_dir = %w(/var/lib/rundeck /var/log/rundeck /etc/rundeck)
default['rundeck']['dir_path'] = rundeck_dir 
