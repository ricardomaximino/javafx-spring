package com.brasajava.config;

import com.brasajava.SpringApplication;
import com.brasajava.config.CustomApplicationContextInitializer;
import com.brasajava.event.StageReadyEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) throws Exception {
        context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void init() throws Exception {
        this.context = new SpringApplicationBuilder()
            .sources(SpringApplication.class)
            .web(WebApplicationType.NONE)
            .initializers(new CustomApplicationContextInitializer(getParameters(), getHostServices(), this))
            .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() throws Exception {
        context.close();
        Platform.exit();
    }
}
