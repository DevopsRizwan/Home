default['tomcat7']['user'] = 'tomcat'
#default['tomcat7']['user']['home'] = '/home/tomcat'
default['tomcat7']['version'] = '7.0.62'
default['tomcat7']['sha1sum'] = 'a650018c17fcf9a3f1aa6a287d1b2bc009fc411b'
default['tomcat7']['mirror'] = 'http://mirrors.koehn.com/apache'
default['tomcat7']['url'] = "#{node['tomcat7']['mirror']}/tomcat/tomcat-7/v#{node['tomcat7']['version']}/bin/apache-tomcat-#{node['tomcat7']['version']}.tar.gz"
default['tomcat7']['install']['dir'] = '/usr/share/tomcat7'
default['tomcat7']['daemon-native-src']['dir'] = "#{node['tomcat7']['install']['dir']}/apache-tomcat-#{node['tomcat7']['version']}"
default['tomcat7']['daemon-native-src']['tar'] = "commons-daemon-native.tar.gz"

default['tomcat7']['home'] = "#{node['tomcat7']['install']['dir']}/apache-tomcat-#{node['tomcat7']['version']}"
