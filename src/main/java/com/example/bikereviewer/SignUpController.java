package com.example.bikereviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton getGenderSignUp;

    @FXML
    private PasswordField getPasswordSignUp;

    @FXML
    private TextArea getUsernameSignUp;

    @FXML
    private Button returnToLoginButton;

    @FXML
    private Button signUpButtonAdd;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void getGenderSignUpFunction(ActionEvent event) {

    }

    @FXML
    void returnToLoginButtonFunction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void signUpButtonAddFunction(ActionEvent event) {

    }
}
