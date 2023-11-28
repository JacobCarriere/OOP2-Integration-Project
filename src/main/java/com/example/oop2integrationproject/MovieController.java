package com.example.oop2integrationproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MovieController {

    public void OnShowTime() throws IOException {
        Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("client-movie-view")));


        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Test");
        nextStage.initModality(Modality.WINDOW_MODAL);

        nextStage.showAndWait();
    }
}
