#!/bin/bash


###################################################################################################
### Author: Tapas K. Chowdhury
### Project: CD2.0 Release Platform
### Description: Sample ScrioptScript to promote an artifact by fetching it from the Nexus SNAPSHOT Repo
### 		 This is just a sample script and proper error handling may need to be added. 
###################################################################################################
export MAVEN_OPTS="-Dmaven.repo.local=/home/cadmin/.m2/repository -Xmx512m -XX:MaxPermSize=192m"
export M2_HOME="/usr/local/maven"

### Below is more of like a verbose option that tells you what all is happening in the script. 
### Good option to use, you may remove it if you do not want it....
set -x

### This should return rundeck as the user. I added this just to test
whoami

### NEXUS RELATED SETTINGS ###
### This is your NExus URL, If you are using a VPC you may want to use the Internal IP (as used below)
### rather than using the public (elastic) IP of your nexus server. This completely depends on how your VPC 
### is configured. Also if your URL has a /nexus as the context root then your URL for curl command shoudl change accordingly.  
REPO_HOST="http://172.30.1.61:8081"

### Following are your repository Ids. These values come from Nexus. 
### Note that for using a REPO ID, the REPO should be already present in the Nexus
REPO_SNAPSHOT_ID="ChefReleasePlatform-SNAPSHOT"
REPO_RELEASE_ID="ChefReleasePlatform-RELEASE"

### These can be provided as options to the Rundeck job. These values come from your POM. 
### Note that for using a GROUP_ID the same needs to be created in Nexus as well. 
GROUP_ID="com.cts.devops"
ARTIFACT_ID="onlinebanking"
#ARTIFACT_VERSION="0.0.1"

### Change this to $REPO_SNAPSHOT_ID or $REPO_RELEASE_ID 
### depending on whether you want to fetch theartifact from snaoshotsnapshot or release repo. 
### Alternatively you may pass this as an option to the Rundeck Job.  
REPO_ID=$REPO_SNAPSHOT_ID


### I do not know wy I added below line, commenting it out since I do not require it now. 
#RELEASE_REPO_URL="http://172.30.1.61:8081/nexus/content/repositories/releases/"


### Note that care shoudl be taken while creating the URL.
### This curl command uses the Nexus API to fetch the war fromt he NExus repo. The source link is: 
### http://stackoverflow.com/questions/7911620/using-the-nexus-rest-api-to-get-latest-artifact-version-for-given-groupid-artfic
### If your Nexus URL is http://your-hostname:8081/nexus, then append the /nexus in the below URL. 
#sudo curl -o $ARTIFACT_ID.war -L "$REPO_HOST/service/local/artifact/maven/redirect?r=$REPO_ID&g=$GROUP_ID&a=$ARTIFACT_ID&e=war&v=LATEST" 
#sudo curl -O -L "$REPO_HOST/service/local/artifact/maven/redirect?r=$REPO_ID&g=$GROUP_ID&a=$ARTIFACT_ID&e=war&v=LATEST" 
url="$REPO_HOST/service/local/artifact/maven/redirect?r=$REPO_ID&g=$GROUP_ID&a=$ARTIFACT_ID&e=war&v=LATEST"
filename=$(curl -sI $url | grep -o -E "$ARTIFACT_ID\-.*war.*$")
#echo $filename
filename=$(echo $filename | tr -d '\r')
#echo $filename
SNAPSHOT_VER=$(echo $filename | sed -e "s/$ARTIFACT_ID\-\([0-9\.]*\).*/\1/")
RELEASE_ARTIFACT="$ARTIFACT_ID-$SNAPSHOT_VER.war"
curl -o $filename -L $url
mv $filename  $RELEASE_ARTIFACT && echo "Renamign the artifact for promoting to qa environment"


rel_url="$REPO_HOST/content/repositories/ChefReleasePlatform-RELEASE"
#$M2_HOME/bin/mvn deploy:deploy-file \
#-Durl=$rel_url \
#-DrepositoryId=$REPO_ID \
#-Dfile=$RELEASE_ARTIFACT \
#-DgroupId=$GROUP_ID \
#-DartifactId=$ARTIFACT_ID \
#-Dversion=$SNAPSHOT_VER
