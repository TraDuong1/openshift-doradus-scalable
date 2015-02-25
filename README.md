Sample Tomcat app that uses Doradus Service
===========================================

This is a sample Openshift Tomcat app that connects to and does CRUD operations on an external Doradus. 

Running on OpenShift
----------------------------

Create an account at https://www.openshift.com

Create Tomcat application 

    rhc app create testapp jbossews-2.0 -g dev-small

Add this upstream repo

    cd testapp
    git remote add upstream https://github.com/TraDuong1/tomcat-doradus-app
    git pull -s recursive -X theirs upstream master

Set the Doradus environment variables
   
    rhc set-env JAVA_OPTS_EXT="-Ddoradus.log.dir=../app-root/logs/“
    rhc env set DORADUS_HOST=<DORADUS_HOST> DORADUS_PORT=<DORADUS_PORT>
rhc env set DORADUS_HOST=10.228.23.117 DORADUS_PORT=1123 DORADUS_DB_USER=SuperDory DORADUS_DB_PASSWORD=Alpha1

Then push the repo upstream

    git push


    Verify
    http://testapp-$yournamespace.$youropenshiftserver/resteasy

    * Using Spring RestTemplate REST client API by adding this maven dependency in your maven project
	
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-web</artifactId>
		<version>3.0.2.RELEASE</version>
	</dependency>
	
    Verify
    http://testapp-$yournamespace.$youropenshiftserver/resttemplate

