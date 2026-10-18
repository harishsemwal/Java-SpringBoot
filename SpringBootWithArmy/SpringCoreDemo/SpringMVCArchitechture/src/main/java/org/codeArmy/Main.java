package org.codeArmy;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.codeArmy.config.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Boiler Plate Code
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File("src/main/webapps").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, baseDoc);


        // IOC Container Up
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(WebConfig.class);

        // Dispatcher Servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);
        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        // Mapping
        context.addServletMappingDecoded("/", "dispatcherServlet");

        // start tomcat
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tomcat started on port 8080");

        // keep Running
        tomcat.getServer().await();

    }
}

// Student ---> Create, Get ---: hashmap