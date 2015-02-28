package com.dell.doradus.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dell.doradus.core.DoradusServer;
import com.dell.doradus.service.olap.OLAPService;
import com.dell.doradus.service.spider.SpiderService;

/**
 * Registering ServletContextListener
 */
@WebListener
public class DoradusServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {  
		//final String[] args = new String[] { "-dbhost", "localhost", "-dbport", "9160"};	
		
		//start Doradus embedded server		
		final String[] args = new String[] { "-dbhost", System.getenv("CASSANDRA_NODE_IP"), "-dbport", System.getenv("CASSANDRA_NODE_PORT"), "-dbuser", System.getenv("CASSANDRA_SUPERUSER_NAME"), "-dbpassword", System.getenv("CASSANDRA_SUPERUSER_PW")};
		
		DoradusServer.startEmbedded(args, SERVICES);		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	private static final String[] SERVICES = new String[]{
        SpiderService.class.getName(),
        OLAPService.class.getName()
    
	};      
 
}
