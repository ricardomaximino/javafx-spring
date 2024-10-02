package com.brasajava;

import com.brasajava.config.JavaFXApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		Application.launch(JavaFXApplication.class, args);
	}

}