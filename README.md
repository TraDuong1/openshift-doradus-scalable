Scalable Doradus Webapp in Openshift
====================================
Using OpenShift Tomcat Webapp to host Doradus to take advantage of Openshift auto-scaling of web gear. 

Running on OpenShift
----------------------------

Create an account at https://www.openshift.com

Create Tomcat 7 application 

    rhc app create doradus jbossews-2.0 -s -g dev-small

Pull the code

    $cd doradus
    $git remote add upstream https://github.com/TraDuong1/openshift-doradus-scalable
    $git pull -s recursive -X theirs upstream master

Set the Doradus environment variables

	to config the proper location of Doradus log file to the same location that is recommended for all application logs file in Openshift  
    $rhc set-env JAVA_OPTS_EXT="-Ddoradus.log.dir=../app-root/logs"
 
 	to tell where the Cassandra cluster/node can be reached and security credentials to access it 
 	For ex: $rhc env set CASSANDRA_NODE_IP=10.228.23.117 CASSANDRA_NODE_PORT=9042 CASSANDRA_SUPERUSER_NAME=SuperDory CASSANDRA_SUPERUSER_PW=Alpha1	

Then push the repo upstream

    $git push
	
Verify Doradus REST API

    http://doradus-$yournamespace.$youropenshiftserver/_api_/applications
[Try this link of Doradus on OSE Prod](http://doradus-tra.us.platform.dell.com/_api/_applications)
      
Tail the logs

	tail all log files (HA log, jboss log and doradus log files) under the same OPENSHIFT_LOG_DIR directory for the primary web gear 
	$rhc tail -a doradus
	
	tail specific log file such as doradus.log
	$rhc tail -f app-root/logs/doradus.log -a doradus   

