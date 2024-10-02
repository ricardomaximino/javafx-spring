package com.brasajava.listener;

import com.brasajava.config.JavaFXApplication;
import com.brasajava.event.StageReadyEvent;
import com.brasajava.exception.JavaFXLoadException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageReadyListener implements ApplicationListener<StageReadyEvent> {
    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
        Stage stage = event.getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApplication.class.getResource("../hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            throw new JavaFXLoadException(e.getMessage());
        }
    }
}
