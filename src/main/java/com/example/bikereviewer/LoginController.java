package com.example.bikereviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class LoginController {

    @FXML
    private PasswordField getPassword;

    @FXML
    private TextArea getUsername;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    void loginAction(ActionEvent event) {
        System.out.println("loginAction running");
    }

    @FXML
    void signUp(ActionEvent event) {
      System.out.println("SignUp running");
    }

}