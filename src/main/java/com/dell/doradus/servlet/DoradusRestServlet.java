package com.dell.doradus.servlet;

import javax.servlet.annotation.WebServlet;

import com.dell.doradus.service.rest.RESTServlet;

/**
 * Servlet implementation class DoradusRestServlet
 */
@WebServlet(name = "DoradusRestServlet", urlPatterns = {"/_api/*"})
public class DoradusRestServlet extends RESTServlet {

	private static final long serialVersionUID = 4815487822036229036L;

}
