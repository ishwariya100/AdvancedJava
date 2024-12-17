package com.demo.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.demo.Utils.Utils;
import com.demo.bean.UserBean;
import com.demo.service.LoginService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.prometheus.PrometheusMeterRegistry;


@WebServlet(urlPatterns = {"/LoginServlet"}, loadOnStartup = 2)
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	// Prometheus registry
    private  PrometheusMeterRegistry registry;
    private  Counter loginAttempts;
    private  Counter successfulLogins;
    private  Counter failureLogins;
    private  Timer loginLatency;
    
    public LoginServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	
    	this.registry = (PrometheusMeterRegistry) getServletContext().getAttribute("prometheusRegistry");
    	
    	// Track login attempts
        this.loginAttempts = Counter.builder("login_attempts_total")
                .description("Total login attempts")
                .register(registry);

        // Track successful logins
        this.successfulLogins = Counter.builder("successful_logins_total")
                .description("Total successful logins")
                .register(registry);
        
     // Track login request latency
        this.loginLatency = Timer.builder("login_request_latency_seconds")
                .description("Login request latency")
                .register(registry);
        
     // Track failure logins
        this.failureLogins = Counter.builder("failure_logins_total")
                .description("Total failure logins")
                .register(registry);
        
        // Register system metrics (CPU, memory, etc.)
        registerSystemMetrics();       
        
    }
    
    private void registerSystemMetrics() {
        // Register JVM metrics
        new JvmMemoryMetrics().bindTo(registry);
        new JvmThreadMetrics().bindTo(registry);
        new JvmGcMetrics().bindTo(registry);
        new ProcessorMetrics().bindTo(registry); // CPU metrics    
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService loginSevice = new LoginService();
		UserBean userBean = new UserBean();	
		
		String error = Utils.validateRequest(request);
		
		 // Start timer for login latency
        Timer.Sample sample = Timer.start(registry);
        
        loginAttempts.increment(); // Increment login attempts counter
		
        logger.info("Login attempt for user: {}", request.getParameter("username"));
        
		if (error == null) {
			userBean.setUsername(request.getParameter("username"));
			userBean.setPassword(request.getParameter("password"));
			error = loginSevice.authenticateUser(userBean);
		}
		
		if(error != null) {
			request.setAttribute("error", error);
			
			failureLogins.increment();
			
			logger.warn("Failed login attempt for user: {}", request.getParameter("username"));
			
			request.getRequestDispatcher("Login.jsp").forward(request, response);			
		}
		else
		{
			successfulLogins.increment();
			
			logger.info("User {} successfully logged in.", request.getParameter("username"));
			
			response.sendRedirect("Success.jsp");			
		}
		
		 // Stop the timer (right before forwarding)
	    sample.stop(loginLatency);
		
	}

}
