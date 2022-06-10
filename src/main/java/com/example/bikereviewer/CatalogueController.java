package com.example.bikereviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CatalogueController implements Initializable {

    @FXML
    private Button UserDeleteButton;

    @FXML
    private Button UserLogoutButton;

    @FXML
    private Button UserUpdateButton;

    @FXML
    private Label welcomeLabel;

    @FXML
    private AnchorPane catalogueAnchorPane;

    @FXML
    private VBox bikesLayout;


    Stage stage;

    private String userName;
    private String email;
    private String password;
    private List<Bike> recentlyAdded;

    @FXML
    void UserDeleteDBFunction(ActionEvent event) {
        Connection con = DBConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE from UserData WHERE Email = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            UserDeleteDBAlertFunction(ps);
            // ps.execute();
            System.out.println("Deletion successful in UserDeleteDBFunction!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void UserDeleteDBAlertFunction(PreparedStatement ps) throws SQLException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting out");
        alert.setHeaderText("You're about to delete the account");
        alert.setContentText("Are you sure you want to delete?:");

        if (alert.showAndWait().get() == ButtonType.OK) {
            // stage = (Stage) catalogueAnchorPane.getScene().getWindow();
            ps.execute();
            System.out.println("Alert Function method");
        }
    }

    @FXML
    void UserLogoutFunction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logging out");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?:");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) catalogueAnchorPane.getScene().getWindow();
            System.out.println("You have successfully logged out!");
            stage.close();
        }
    }

    @FXML
    void UserUpdateDBFunction(ActionEvent event) {

    }

    public void setUserData(String userEmail, String userPassword, String userId) {
        email = userEmail;
        password = userPassword;
        userName = userId;
        setWelcomeLabel(userName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Not able to set welcome label using the below methods here.
        //setWelcomeLabel(userName);
        // welcomeLabel.setText("Welcome " + userName);

        recentlyAdded = new ArrayList<>(recentlyAdded());
        try {
            for (int i = 0; i < recentlyAdded.size(); i++) {
                System.out.println("Loop successfully started");
                FXMLLoader fxmlLoader = new FXMLLoader();
                System.out.println("1");
                fxmlLoader.setLocation(getClass().getResource("SingleBike.fxml"));
                System.out.println("2");
                VBox cardBox = fxmlLoader.load();
                System.out.println("3");
                BikeController bikeController = fxmlLoader.getController();
                System.out.println("4");
                bikeController.setData(recentlyAdded.get(i));
                System.out.println("5");
                bikesLayout.getChildren().add(cardBox);
                System.out.println("loop ended");
            }

    } catch(IOException e) {
            System.out.println("Error in initialize()");
        e.printStackTrace();
    }

}

    private List<Bike> recentlyAdded(){
        List<Bike> ls = new ArrayList<>();
        Bike bike = new Bike();
        bike.setBikeImageSrc("/demo/1.jpg");
        System.out.println(bike.getBikeImageSrc());
        bike.setBikeName("Bike No.1");
        bike.setBikePrice("Rs. 3.7 lakh");
        ls.add(bike);
        System.out.println("1st bike added");

        bike = new Bike();
        bike.setBikeImageSrc("/demo/2.jpg");
        bike.setBikeName("Bike No.2");
        bike.setBikePrice("Rs. 3.8 lakh");
        ls.add(bike);
        System.out.println("2st bike added");
        return ls;
    }

    public void setWelcomeLabel(String userName){
        welcomeLabel.setText("Welcome " + userName);
   }


    //Unused method for setONcloseRequest
    public void setOnCloseRequest(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logging out");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?:");

        if(alert.showAndWait().get() == ButtonType.OK){
           // stage = (Stage) catalogueAnchorPane.getScene().getWindow();
            System.out.println("You have successfully logged out!");
            stage.close();
        }
    }

}
