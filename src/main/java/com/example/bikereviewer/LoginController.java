package com.example.bikereviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private PasswordField getPassword;

    @FXML
    private TextArea getUsername;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void loginAction(ActionEvent event) {
        System.out.println("loginAction running");
    }


    @FXML
    void signUp(ActionEvent event) throws IOException {
        //System.out.println("SignUp running");
        root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign up window");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //getUsername.setStyle("-fx-text-inner-color: #a0a2ab");
        //getPassword.setStyle("-fx-text-inner-color: #a0a2ab");

    }
}