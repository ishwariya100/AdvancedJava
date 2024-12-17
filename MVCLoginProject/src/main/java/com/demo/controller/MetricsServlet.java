package com.demo.controller;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.exporter.common.TextFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/metrics"}, loadOnStartup = 1)
public class MetricsServlet extends HttpServlet{
	
	private PrometheusMeterRegistry registry;
	
	 @Override
	    public void init() throws ServletException {
	        // Get the registry from the servlet context
	        this.registry = (PrometheusMeterRegistry) getServletContext().getAttribute("prometheusRegistry");
	    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(TextFormat.CONTENT_TYPE_004);
        resp.getWriter().write(registry.scrape());
    }
}
