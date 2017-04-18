package com.minorius;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by minorius on 04.04.2017.
 */
public class DispatcherInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext dispatcherInit = new AnnotationConfigWebApplicationContext();
        dispatcherInit.register(ThymeleafConfig.class);

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherInit));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
