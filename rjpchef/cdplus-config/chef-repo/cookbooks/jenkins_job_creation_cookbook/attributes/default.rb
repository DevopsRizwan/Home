default['jenkins']['master']['user'] = 'cadmin'
default['jenkins']['master']['group'] = 'cadmin'
default['jenkins']['master']['super_user'] = 'root'

default['jenkins']['master']['host'] = '52.4.102.166' ### IP mentioned here is internal, this is based on AWS security settings
default['jenkins']['master']['port'] = 8085
default['jenkins']['master']['endpoint'] = "http://#{node['jenkins']['master']['host']}:#{node['jenkins']['master']['port']}"

job_creation_dir = %w(OnlineBanking333_Checkout OnlineBanking333_MavenBuild OnlineBanking333_SonarAnalysis OnlineBanking333_PublishToNexus OnlineBanking333_RundeckDeploy)
default['jenkins']['master']['job_dir'] = job_creation_dir
default['jenkins']['master']['path_to_default_dir'] = '/var/lib/jenkins/config_dir/'
config_files_for_job_creation = %w(Checkout_Config.xml MavenBuild_Config.xml PublishToNexus_Config.xml RundeckDeploy_Config.xml SonarAnalysis_Config.xml job_creation.sh)
default['jenkins']['master']['job_config_files'] = config_files_for_job_creation

#checkout job attributes
default['jenkins']['parent_job'] = 'OnlineBanking333_Checkout'
default['jenkins']['app']['group_id'] = 'com.cts.devops'
default['jenkins']['app']['artifact_id'] = 'onlinebanking'
default['jenkins']['app']['root_pom'] = 'online-banking/pom.xml'

default['jenkins']['checkout_job']['git_url'] = 'git@github.com:CogDOPlus/cdplus-config.git'
default['jenkins']['checkout_job']['branch_name'] = '*/master'
default['jenkins']['checkout_job']['scm_pool_time'] = '*/1 * * * *'
default['jenkins']['checkout_job']['child_project'] = 'OnlineBanking333_MavenBuild'

default['jenkins']['build_job']['child_project'] = 'OnlineBanking333_SonarAnalysis'
default['jenkins']['sonar_job']['child_project'] = 'OnlineBanking333_PublishToNexus'
default['jenkins']['nexus_job']['child_project'] = 'OnlineBanking333_RundeckDeploy'
default['jenkins']['rundeck_job']['job_id'] = 'a6864dfe-6bca-4438-8943-e1381e75652a'
