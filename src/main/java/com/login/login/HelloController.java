package com.login.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    // Strings which hold css elements to easily re-use in the application
    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    // Import the application's controls
    @FXML
    private Label invalidLoginCredentials;
    @FXML
    private Label invalidSignupCredentials;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private TextField loginPasswordPasswordField;
    @FXML
    private TextField signUpUsernameTextField;
    @FXML
    private TextField signUpEmailTextField;
    @FXML
    private TextField signUpPasswordPasswordField;
    @FXML
    private TextField signUpRepeatPasswordPasswordField;

    // Creation of methods which are activated on events in the forms
    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onLoginButtonClick() {
        if (loginUsernameTextField.getText().isBlank() || loginPasswordPasswordField.getText().isBlank()) {
            invalidLoginCredentials.setText("The Login fields are required!");
            invalidLoginCredentials.setStyle(errorMessage);
            invalidSignupCredentials.setText("");

            if (loginUsernameTextField.getText().isBlank()) {
                loginUsernameTextField.setStyle(errorStyle);
            } else if (loginPasswordPasswordField.getText().isBlank()) {
                loginPasswordPasswordField.setStyle(errorStyle);
            }
        } else {
            invalidLoginCredentials.setText("Login Successful!");
            invalidLoginCredentials.setStyle(successMessage);
            loginUsernameTextField.setStyle(successStyle);
            loginPasswordPasswordField.setStyle(successStyle);
            invalidSignupCredentials.setText("");
        }
    }

    @FXML
    protected void onSignUpButtonClick() {

        if (signUpUsernameTextField.getText().isBlank() || signUpEmailTextField.getText().isBlank() || signUpPasswordPasswordField.getText().isBlank() || signUpRepeatPasswordPasswordField.getText().isBlank()) {
            invalidSignupCredentials.setText("Please fill in all fields!");
            invalidSignupCredentials.setStyle(errorMessage);
            invalidLoginCredentials.setText("");

            if (signUpUsernameTextField.getText().isBlank()) {
                signUpUsernameTextField.setStyle(errorStyle);
            } else if (signUpEmailTextField.getText().isBlank()) {
                signUpEmailTextField.setStyle(errorStyle);
            } else if (signUpPasswordPasswordField.getText().isBlank()) {
                signUpPasswordPasswordField.setStyle(errorStyle);
            } else if (signUpRepeatPasswordPasswordField.getText().isBlank()) {
                signUpRepeatPasswordPasswordField.setStyle(errorStyle);
            }
        } else if (signUpRepeatPasswordPasswordField.getText().equals(signUpPasswordPasswordField.getText())) {
            invalidSignupCredentials.setText("You are set!");
            invalidSignupCredentials.setStyle(successMessage);
            signUpUsernameTextField.setStyle(successStyle);
            signUpEmailTextField.setStyle(successStyle);
            signUpPasswordPasswordField.setStyle(successStyle);
            signUpRepeatPasswordPasswordField.setStyle(successStyle);
            invalidLoginCredentials.setText("");
        } else {
            invalidSignupCredentials.setText("The Passwords don't match!");
            invalidSignupCredentials.setStyle(errorMessage);
            signUpPasswordPasswordField.setStyle(errorStyle);
            signUpRepeatPasswordPasswordField.setStyle(errorStyle);
            invalidLoginCredentials.setText("");
        }
    }
}