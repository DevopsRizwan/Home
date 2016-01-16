default['maven']['version'] = 3
default['maven']['m2_home'] = '/usr/local/maven'
default['maven']['download']['location'] = '/tmp/apache-maven.tar.gz'
default['maven']['mavenrc']['opts'] = '-Dmaven.repo.local=$HOME/.m2/repository -Xmx512m -XX:MaxPermSize=192m'
default['maven']['3']['version'] = '3.1.1'
default['maven']['3']['url'] = "http://apache.mirrors.tds.net/maven/maven-3/#{node['maven']['3']['version']}/binaries/apache-maven-#{node['maven']['3']['version']}-bin.tar.gz"
default['maven']['3']['checksum'] = '077ed466455991d5abb4748a1d022e2d2a54dc4d557c723ecbacdc857c61d51b'

default['maven']['nexus']['username'] = 'admin'
default['maven']['nexus']['password'] = 'admin123'
default['maven']['nexus']['repo_id'] = 'ChefReleasePlatform-SNAPSHOT'
