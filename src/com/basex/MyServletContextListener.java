package com.basex;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
public class MyServletContextListener implements ServletContextListener {
 
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("context initialized");
	}
 
	public void contextDestroyed(ServletContextEvent event) {
	}
 
}