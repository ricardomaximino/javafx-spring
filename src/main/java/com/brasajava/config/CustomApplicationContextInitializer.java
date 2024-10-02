package com.brasajava.config;

import javafx.application.Application;
import javafx.application.HostServices;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

public class CustomApplicationContextInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
    private Application.Parameters parameters;
    private HostServices hostServices;
    private Application javaFXApplication;
    public CustomApplicationContextInitializer(Application.Parameters parameters, HostServices hostServices, Application javaFXApplication) {
        this.parameters = parameters;
        this.hostServices = hostServices;
        this.javaFXApplication = javaFXApplication;
    }
    @Override
    public void initialize(GenericApplicationContext ac) {
        ac.registerBean(Application.class, () -> this.javaFXApplication);
        ac.registerBean(Application.Parameters.class, () -> this.parameters);
        ac.registerBean(HostServices.class, () -> this.hostServices);
    }
}
