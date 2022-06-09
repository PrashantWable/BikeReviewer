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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private PasswordField getPassword;

    @FXML
    private TextField getUserEmail;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String userEmail;
    private String password;

    @FXML
    void loginAction(ActionEvent event) {
        System.out.println("loginAction running");
        userEmail = getUserEmail();
        password = getPassword();

        if (password.equals(readPasswordFromDB(userEmail, password))){
            System.out.println("Correct password");
        }
        else{
            System.out.println("Wrong Password");
        }


    }

   private static String readPasswordFromDB(String userEmail, String password){
       Connection con = DBConnection.connect();
       PreparedStatement ps = null;
       ResultSet rs = null;
       String receivedPasswordFromDB = "";
       try {
           String sql = "Select Password from UserData where email = ?";
           ps = con.prepareStatement(sql);
           ps.setString(1, userEmail);
           rs = ps.executeQuery();
           receivedPasswordFromDB = rs.getString(1);
       } catch (SQLException e) {
           System.out.println("Wrong Password");
           //e.printStackTrace();
       } finally {
           try {
               rs.close();
               ps.close();
               con.close();
           } catch (SQLException e) {
               System.out.println("DataBase connection closing error");
               //e.printStackTrace();
           }
       }
           return receivedPasswordFromDB;
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
    @FXML
    public String getUserEmail(){
        return getUserEmail.getText();
    }

    @FXML
    public String getPassword(){
        return getPassword.getText();
    }

}