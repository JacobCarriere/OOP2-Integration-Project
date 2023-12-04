package com.example.oop2integrationproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the login controller that will allow the user to enter the application as manager or client
 */
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private static final String CSV_FILE_PATH = "src/main/java/com/example/oop2integrationproject/Data.csv";

    public void SignUpButtonClicked(ActionEvent actionEvent) {
        try {
            String fxmlFile = "signup-view.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root));
            nextStage.setTitle("Movies");
            nextStage.initModality(Modality.WINDOW_MODAL);

            nextStage.showAndWait();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading FXML file", e);
        }
    }
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private Client isUserValid() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            String delimiter = ",";

            while ((line = br.readLine()) != null) {
                String[] userData = line.split(delimiter);

                if (isUserInputValid(userData)) {
                    return new Client(userData[0], userData[1], userData[2], userData[3]);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading CSV file", e);
        }
        return null;
    }

    private boolean isUserInputValid(String[] userData) {
        return userData.length >= 5 && userData[2].equals(emailField.getText()) && userData[3].equals(passwordField.getText());
    }

    private void openViewBasedOnRole(Client client) {
        try {
            String fxmlFile = (client != null && client.getName().equals("Client")) ? "client-movie-view.fxml" : "manager-home-view.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root));
            nextStage.setTitle("Movies");
            nextStage.initModality(Modality.WINDOW_MODAL);

            nextStage.showAndWait();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading FXML file", e);
        }
    }

    public void loginButtonClicked(ActionEvent actionEvent) {
        Client client = isUserValid();
        LOGGER.info("User role: " + (client != null ? client.getName() : "null"));

        if (client != null) {
            openViewBasedOnRole(client);
        } else {
            LOGGER.warning("Invalid user input");
            // Handle invalid user input
        }
    }
}
