default['sonar']['dir'] = "/opt/sonar"
default['sonar']['version'] = "5.1"
default['sonar']['checksum'] = "6a70c7df869eea4079b405f183f81b3e"
default['sonar']['mirror'] = "http://dist.sonar.codehaus.org"
default['sonar']['os_kernel'] = "linux-x86-64"
default['mysql']['create_db_file']['path'] = "/opt/sonar/extras/database/mysql/create_database.sql"
default['mysql']['password'] = "root"
default['sonar']['webhost']['public']= '52.4.102.166'
default['sonar']['webhost']['default'] = '0.0.0.0'
default['sonar']['webhost']['localhost'] = 'localhost'
default['sonar']['webport']['default'] = '9000'
#default['sonar']['webcontext'] = 'sonar'
default['mysql']['port'] = '3306'
default['sonar']['jdbc']['username'] = 'sonar'
default['sonar']['jdbc']['password'] = 'sonar'
default['sonar']['jdbc']['params'] = "useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&useConfigs=maxPerformance"
default['sonar']['jdbc']['url'] = "jdbc:mysql://#{node['sonar']['webhost']['localhost']}:#{node['mysql']['port']}/sonar?#{node['sonar']['jdbc']['params']}"
default['sonar']['jdbc']['driver_classname'] = 'com.mysql.jdbc.Driver'
default['sonar']['jdbc']['validationquery'] = 'select 1'


