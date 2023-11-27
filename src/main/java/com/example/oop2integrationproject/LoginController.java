package com.example.oop2integrationproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private static final String CSV_FILE_PATH = "src/main/java/com/example/oop2integrationproject/Data.csv";

    public void SignUpButtonClicked(ActionEvent actionEvent) {
        // Add SignUp logic if needed
    }

    private String isUserValid() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            String delimiter = ",";

            while ((line = br.readLine()) != null) {
                String[] user = line.split(delimiter);

                if (isUserInputValid(user)) {
                    return user[4].replace("\"", "");
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading CSV file", e);
        }
        return null;
    }

    private boolean isUserInputValid(String[] user) {
        return user.length >= 5 && user[2].equals(emailField.getText()) && user[3].equals(passwordField.getText());
    }

    private void openViewBasedOnRole(String userRole) {
        try {
            String fxmlFile = (userRole.equals("Client")) ? "movie-view.fxml" : "ManagerView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root, 500, 500));
            nextStage.setTitle("Test");
            nextStage.initModality(Modality.WINDOW_MODAL);

            nextStage.showAndWait();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading FXML file", e);
        }
    }

    public void loginButtonClicked(ActionEvent actionEvent) {
        String userRole = isUserValid();
        LOGGER.info("User role: " + userRole);

        if (userRole != null) {
            openViewBasedOnRole(userRole);
        } else {
            LOGGER.warning("Invalid user input");
            // Handle invalid user input
        }
    }
}
