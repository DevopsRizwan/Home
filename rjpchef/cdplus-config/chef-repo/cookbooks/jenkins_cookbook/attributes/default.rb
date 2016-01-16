#### Jenkins common attributes
default['jenkins']['master']['host'] = '172.30.1.167' ### IP mentioned here is internal, this is based on AWS security settings
default['jenkins']['master']['version'] = '1.613-1.1'
default['jenkins']['master']['rpm'] = "jenkins-#{node['jenkins']['master']['version']}.noarch.rpm"
default['jenkins']['master']['url'] = "http://pkg.jenkins-ci.org/redhat/#{node['jenkins']['master']['rpm']}"
default['jenkins']['master']['home'] = '/var/lib/jenkins'
default['jenkins']['java'] = '/usr/bin/java'
default['jenkins']['master']['jvm_options'] = nil
default['jenkins']['master']['port'] = 8085
default['jenkins']['master']['listen_address'] = '0.0.0.0'
default['jenkins']['master']['jenkins_args'] = nil
default['jenkins']['master']['jdk_path'] = '/usr/lib/jvm/java-1.7.0-openjdk.x86_64'
default['jenkins']['master']['maven_path'] = '/usr/local/maven'

###Creation of View
default['jenkins']['master']['view_name'] = 'OnlineBankingPipeline11_View'
default['jenkins']['master']['first_job'] = 'OnlineBanking333_Checkout'

### Global configuration related attributes
global_config_files = %w(config.xml credentials.xml hudson.maven.MavenModuleSet.xml hudson.model.UpdateCenter.xml hudson.scm.CVSSCM.xml hudson.scm.SubversionSCM.xml hudson.tasks.Ant.xml hudson.tasks.Mailer.xml hudson.tasks.Maven.xml hudson.tasks.Shell.xml hudson.triggers.SCMTrigger.xml jenkins.model.ArtifactManagerConfiguration.xml jenkins.model.JenkinsLocationConfiguration.xml jenkins.mvn.GlobalMavenConfig.xml hudson.plugins.git.GitTool.xml hudson.plugins.git.GitSCM.xml org.jenkinsci.plugins.rundeck.RundeckNotifier.xml)
default['jenkins']['master']['config_files'] = global_config_files
default['jenkins']['master']['git']['default'] = 'git-default'
default['jenkins']['master']['git']['default-location'] = '/usr/bin/git'
default['jenkins']['master']['git']['globalconfigusername']= 'DevOpsTapas'
default['jenkins']['master']['git']['globalconfiguseremail']= 'tapas.chowdhury@cognizant.com'

### Below attribute takes the directories that shoudl be owned by the user with which jenkins is runnig
jenkins_ownership_dir = %w(/var/lib/jenkins /var/log/jenkins /var/cache/jenkins /var/lib/jenkins/plugins)
default['jenkins']['master']['dir_path'] = jenkins_ownership_dir

## plugin installation related attributes
default['jenkins']['master']['endpoint'] = "http://#{node['jenkins']['master']['host']}:#{node['jenkins']['master']['port']}"
default['jenkins']['executor']['timeout'] = 60
default['jenkins']['master']['mirror'] = 'http://mirrors.jenkins-ci.org'
default['jenkins']['master']['user'] = 'jenkins'
default['jenkins']['master']['group'] = 'jenkins'
default['jenkins']['master']['super_user'] = 'root'

### ANy new plugin to be downlaoded from a URL is to be added in the below array
#### The name of the plugin should be same as the one mnentioned in the plugin URL
### This lists the plugins to be installed. Plugins are installed through jenkins cli, so dependencies are downloaded automatically, This is just awesome code!!!
### Plugins need to be mentioned int he following format in the below array:
#plugin-exact-name: plugin-version
#default['jenkins']['master']['plugins'] = ["git: 2.3.5","credentials: 1.18","build-pipeline-plugin: 1.4.7","artifactory: 2.3.0", "jenkins-multijob-plugin: 1.16"]
default['jenkins']['master']['plugins'] = ["git: 2.3.5","build-pipeline-plugin: 1.4.7","clone-workspace-scm: 0.6","rundeck: 3.4"]

