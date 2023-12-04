package com.example.oop2integrationproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupController {

    private static final Logger LOGGER = Logger.getLogger(SignupController.class.getName());

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField password;


    private static final String CSV_FILE_PATH = "src/main/java/com/example/oop2integrationproject/Data.csv";

    public void signupClickedButton(ActionEvent actionEvent) {
        Client newClient = createNewClient();
        if (newClient != null) {
            writeUserDataToCSV(newClient);
        }
    }
    private Client createNewClient() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE_PATH));

            // Find the next available ID
            int nextId = 1;
            for (String line : lines) {
                String[] user = line.split(",");
                if (user.length > 0 && !user[0].isEmpty()) {
                    int userId = Integer.parseInt(user[0]);
                    nextId = Math.max(nextId, userId + 1);
                }
            }

            // Create the new client
            String newClientId = String.valueOf(nextId);
            String newClientName = firstName.getText() + " " + lastName.getText();
            String newClientEmail = email.getText();
            String newClientPassword = password.getText();

            return new Client(newClientId, newClientName, newClientEmail, newClientPassword);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading CSV file", e);
            return null;
        }
    }

    private boolean isValidEmail(String email) {
        // Simple email validation
        return email != null && email.contains("@") && email.endsWith(".com");
    }

    private boolean isValidPasswordLength(String password) {
        // Password length validation
        int minLength = 4;
        int maxLength = 16;
        return password != null && password.length() >= minLength && password.length() <= maxLength;
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.showAndWait();
    }


    private void writeUserDataToCSV(Client newClient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.newLine();
            writer.write(newClient.getClientID() + "," + newClient.getName() + ","
                    + newClient.getEmail() + "," + newClient.getPassword() + ",Client");
            LOGGER.info("User created: " + newClient.getName());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing to CSV file", e);
        }
    }
}

