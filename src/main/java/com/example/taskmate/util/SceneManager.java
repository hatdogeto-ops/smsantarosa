package com.example.taskmate.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static Stage stage;

    public static void setStage(Stage primaryStage){
        stage = primaryStage;;
    }

    public static void switchScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/com/example/taskmate/" + fxml));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
