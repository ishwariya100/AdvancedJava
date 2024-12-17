package com.demo.Listener;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
	
	private PrometheusMeterRegistry registry;
	/*
	private static String jdbcURL;
    private static String jdbcUsername;
    private static String jdbcPassword;*/

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	
        // Initialize the Prometheus registry
        registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        
        // Store it in the servlet context to share between servlets
        ServletContext context = sce.getServletContext();
        context.setAttribute("prometheusRegistry", registry);
        /*
        jdbcURL = context.getInitParameter("jdbc.url");
        jdbcUsername = context.getInitParameter("jdbc.username");
        jdbcPassword = context.getInitParameter("jdbc.password");*/
    }

    public PrometheusMeterRegistry getRegistry() {
        return registry;
    }
    
    /*
    public static String getJdbcURL() {
        return jdbcURL;
    }

    public static String getJdbcUsername() {
        return jdbcUsername;
    }

    public static String getJdbcPassword() {
        return jdbcPassword;
    }*/
}
