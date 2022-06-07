package com.example.bikereviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Label DisplayLabelSignUp;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton getFemaleGenderSignUp;

    @FXML
    private RadioButton getMaleGenderSignUp;

    @FXML
    private PasswordField getPasswordSignUp;

    @FXML
    private TextField getUsernameSignUp;

    @FXML
    private Button returnToLoginButton;

    @FXML
    private Button signUpButtonAdd;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String userName;
    private String password;
    private String gender;


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
      userName = getUsernameSignUp();
      password = getPasswordSignUp();
      //System.out.println(userName + " " + password + " " + gender);
      if (userName.equals("") || password.equals("") || gender.equals("")){
          DisplayLabelSignUp.setVisible(true);
          DisplayLabelSignUp.setText("Enter all the fields");
      }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DisplayLabelSignUp.setVisible(false);
    }

    @FXML
    public void getGenderSignUpFunction(ActionEvent event){
      if (getMaleGenderSignUp.isSelected()){
          gender = "Male";
      } else if(getFemaleGenderSignUp.isSelected()){
          gender = "Female";
      }
      else {
          gender = "";
      }
    }

    @FXML
    public String getUsernameSignUp(){
            return getUsernameSignUp.getText();
    }

    @FXML
    public String getPasswordSignUp(){
            return getPasswordSignUp.getText();
    }

}
