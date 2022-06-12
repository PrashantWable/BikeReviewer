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

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Label madeByLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String userEmail;
    private String password;

    private String receivedUserNameDB;
    private int receivedRating1;
    private int receivedRating2;
    private int receivedRating3;
    private int receivedRating4;
    private int receivedRating5;
    private int receivedRating6;
    private int receivedRating7;
    private int receivedRating8;

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        System.out.println("loginAction running");
        userEmail = getUserEmail();
        password = getPassword();

        if (password.equals(readPasswordFromDB(userEmail))){
            System.out.println("Correct password");
            //Storing User data so that it can be passed to different controllers
          //  User u = new User(userEmail, password, receivedUserNameDB);
            //Loading new scenes because the above condition is satisfied
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Catalogue.fxml"));
            root = loader.load();
            //Passing info to catalogue controller by initializing a object using a FXMLoader.
            CatalogueController catalogueController = loader.getController();
            System.out.println(receivedUserNameDB);
            catalogueController.setUserData(userEmail, password, receivedUserNameDB, receivedRating1, receivedRating2,
                    receivedRating3, receivedRating4, receivedRating5, receivedRating6, receivedRating7, receivedRating8);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // used to send the data from this controller to catalogue controller
           // stage.setUserData(u);
            stage.setTitle("Catalogues");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        else{
            System.out.println("Wrong Password in loginAction()");
            loginMessageLabel.setVisible(true);
            loginMessageLabel.setText("Wrong username or password!");
        }


    }

   private String readPasswordFromDB(String userEmail){
       Connection con = DBConnection.connect();
       PreparedStatement ps = null;
       ResultSet rs = null;
       String receivedPasswordFromDB = "";
       try {
           String sql = "Select Password, UserNames, rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8 from UserData where email = ? ";
           ps = con.prepareStatement(sql);
           ps.setString(1, userEmail);
           rs = ps.executeQuery();
           receivedPasswordFromDB = rs.getString(1);
           receivedUserNameDB = rs.getString(2);
           receivedRating1 = rs.getInt(3);
           receivedRating2 = rs.getInt(4);
           receivedRating3 = rs.getInt(5);
           receivedRating4 = rs.getInt(6);
           receivedRating5 = rs.getInt(7);
           receivedRating6 = rs.getInt(8);
           receivedRating7 = rs.getInt(9);
           receivedRating8 = rs.getInt(10);

           System.out.println("Pass:"+ receivedPasswordFromDB + " Name:"+ receivedUserNameDB + " Rating2:" + receivedRating2);
       } catch (SQLException e) {
           System.out.println("Wrong Password in readPasswordFromDB()");
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
        loginMessageLabel.setVisible(false);
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