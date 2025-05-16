package com.example.fortunetelling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FortuneTellingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FortuneTellingApplication.class.getResource("FortuneTellingView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 400);
        stage.setTitle("Fortune Telling App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
