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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private TextField getUserEmailSignUp;

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
    private String Email;


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
      Email = getUserEmailSignUp();
      //System.out.println(userName + " " + password + " " + gender);
      if (userName.equals("") || password.equals("") || gender.equals("") || Email.equals("")){
          DisplayLabelSignUp.setVisible(true);
          DisplayLabelSignUp.setText("Enter all the fields");
      }
      else{
                insertIntoDB(Email, userName, password, gender);

      }
    }

    private void insertIntoDB(String Email, String userName, String password, String gender){
        Connection con = DBConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO UserData(Email, UserNames, Password, Gender) VALUES(?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, userName);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.execute();
            System.out.println("Data has been inserted!");
            DisplayLabelSignUp.setVisible(true);
            DisplayLabelSignUp.setText("Account successfully created");
        } catch (SQLException e) {
            //e.printStackTrace();
            DisplayLabelSignUp.setVisible(true);
            DisplayLabelSignUp.setText("Email already registered!");
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

    @FXML
    public String getUserEmailSignUp() { return getUserEmailSignUp.getText(); }

}
