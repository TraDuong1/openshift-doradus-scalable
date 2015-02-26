Scalable Doradus Webapp inside Openshift
===========================================

OpenShift Tomcat Webapp to host Doradus to take advantage of Openshift auto-scaling of web gear. 

Running on OpenShift
----------------------------

Create an account at https://www.openshift.com

Create Tomcat application 

    rhc app create doradus jbossews-2.0 -g dev-small

Add this upstream repo

    cd testapp
    git remote add upstream https://github.com/TraDuong1/openshift-doradus-scalable
    git pull -s recursive -X theirs upstream master

Set the Doradus environment variables

	to config the proper location of Doradus log file which is recommended for all application logs file in Openshift  
    rhc set-env JAVA_OPTS_EXT="-Ddoradus.log.dir=../app-root/logs"
 
 	to tell where the Cassandra cluster/node can be reached and security credentials to access it 
 	For ex: rhc env set CASSANDRA_NODE_IP=10.228.23.117 CASSANDRA_NODE_PORT=9042 CASSANDRA_SUPERUSER_NAME=SuperDory CASSANDRA_SUPERUSER_PW=Alpha1
	

Then push the repo upstream

    git push

Tail the logs

	Tail all application log files including Doradus logs  of the application
	rhc tail -a doradus
	
Verify
    http://doradus-$yournamespace.$youropenshiftserver/api_/applications

