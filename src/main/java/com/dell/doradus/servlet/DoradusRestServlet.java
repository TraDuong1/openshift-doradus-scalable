package com.dell.doradus.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;

import com.dell.doradus.core.DoradusServer;
import com.dell.doradus.service.olap.OLAPService;
import com.dell.doradus.service.rest.RESTServlet;
import com.dell.doradus.service.spider.SpiderService;

/**
 * Servlet implementation class DoradusRestServlet
 */
@WebServlet(name = "DoradusRestServlet", urlPatterns = {"/api/*"})
public class DoradusRestServlet extends RESTServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] SERVICES = new String[]{
        SpiderService.class.getName(),
        OLAPService.class.getName()
    
	};      
 
	@Override
	public void init(ServletConfig config)  {
		
    	//System.out.println("DORADUS_HOST: " + System.getenv("DORADUS_HOST"));
    	//System.out.println("DORADUS_PORT: " + System.getenv("DORADUS_PORT"));
       	//System.out.println("DORADUS_DB_USER: " + System.getenv("DORADUS_DB_USER"));
      	//System.out.println("DORADUS_DB_PASSWORD: " + System.getenv("DORADUS_DB_PASSWORD"));
      	//System.out.println("OPENSHIFT_LOG_DIR: " + System.getenv("OPENSHIFT_LOG_DIR"));      	
		//final String[] args = new String[] { "-dbhost", "10.228.23.117", "-dbport", "9042", "-dbuser", "SuperDory", "-dbpassword", "Alpha1"};
		//final String[] args = new String[] { "-dbhost", "localhost", "-dbport", "9160"};
		//System.out.println("doradus.log.dir:  " + System.getProperty("doradus.log.dir"));   			
      	
		//start Doradus embedded server
		final String[] args = new String[] { "-dbhost", System.getenv("DORADUS_HOST"), "-dbport", System.getenv("DORADUS_PORT"), "-dbuser", System.getenv("DORADUS_DB_USER"), "-dbpassword", System.getenv("DORADUS_DB_PASSWORD")};
		DoradusServer.startEmbedded(args, SERVICES);
	}
	

}
