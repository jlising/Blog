package com.lisinglearning.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppInitializer.class);
	
	public void onStartup(ServletContext container) throws ServletException {
		LOG.debug("Starting up web container: container={}", container);
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		
		// Set configuration scans
		context.scan("com.lisinglearning.config");
		context.scan("com.lisinglearning.**.config");

		container.addListener(new ContextLoaderListener(context));

		//Configure security layer
		//FilterRegistration.Dynamic springSecFilter = container.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
		//springSecFilter.setAsyncSupported(true);
		//springSecFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC), true, "/*");

		//Set dispatchers
		ServletRegistration.Dynamic mvcDispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));
		mvcDispatcher.setLoadOnStartup(1);
		mvcDispatcher.addMapping("/");
	}
}
