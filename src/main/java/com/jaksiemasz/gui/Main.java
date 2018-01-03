package com.jaksiemasz.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        final Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Company App");
        primaryStage.getIcons().add(new Image("sphere.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


        primaryStage.setOnCloseRequest(e -> Platform.exit());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
