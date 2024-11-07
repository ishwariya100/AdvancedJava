package com.demo.Listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
	
	private PrometheusMeterRegistry registry;
	private static String jdbcURL;
    private static String jdbcUsername;
    private static String jdbcPassword;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
   
        registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
     
        ServletContext context = sce.getServletContext();
        context.setAttribute("prometheusRegistry", registry);
        
        jdbcURL = context.getInitParameter("JDBC_URL");
        jdbcUsername = context.getInitParameter("JDBC_USERNAME");
        jdbcPassword = context.getInitParameter("JDBC_PASSWORD");
    
    }
    
    public PrometheusMeterRegistry getRegistry() {
        return registry;
    }
    
    public static String getJdbcURL() {
        return jdbcURL;
    }

    public static String getJdbcUsername() {
        return jdbcUsername;
    }

    public static String getJdbcPassword() {
        return jdbcPassword;
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
   

}
