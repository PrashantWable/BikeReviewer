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

    @FXML
    private Button saveInDB;


    Stage stage;

    private String userName;
    private String email;
    private String password;
    private int rating1;
    private int rating2;
    private int rating3;
    private int rating4;
    private int rating5;
    private int rating6;
    private int rating7;
    private int rating8;
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
        alert.setHeaderText("You're about to delete the account! All progress will be lost out.");
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
        alert.setContentText("Progress will not be saved!");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) catalogueAnchorPane.getScene().getWindow();
            System.out.println("You have successfully logged out!");
            stage.close();
        }
    }

    @FXML
    void UserUpdateDBFunction(ActionEvent event) {

    }

    public void setUserData(String userEmail, String userPassword, String userId, int rating1, int rating2, int rating3, int rating4,
                            int rating5, int rating6, int rating7, int rating8) {
        email = userEmail;
        password = userPassword;
        userName = userId;
        //this.rating1 = rating1;
        //this.rating2 = rating2;
        setWelcomeLabel(userName, rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8);
      //  System.out.println("rating1 = " + rating1);
      //  System.out.println("rating2 = "+ rating2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Not able to set welcome label using the below methods here.
        //setWelcomeLabel(userName);
        // welcomeLabel.setText("Welcome " + userName);

//        recentlyAdded = new ArrayList<>(recentlyAdded());
//        try {
//            for (int i = 0; i < recentlyAdded.size(); i++) {
//                System.out.println("Loop successfully started");
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("SingleBike.fxml"));
//                VBox cardBox = fxmlLoader.load();
//                BikeController bikeController = fxmlLoader.getController();
//                bikeController.setData(recentlyAdded.get(i));
//                bikesLayout.getChildren().add(cardBox);
//           }
//    } catch(IOException e) {
//            System.out.println("Error in initialize()");
//        e.printStackTrace();
//    }

}

    private List<Bike> recentlyAdded(){
        List<Bike> ls = new ArrayList<>();
        Bike bike = new Bike();
        bike.setBikeImageSrc("/demo/1.Honda_Hness_CB350.JPG");
        bike.setBikeName("Honda H'ness CB350");
        bike.setBikePrice("Rs. 1.98 - 2.05 Lakh");
        bike.setBikeRatings(rating1);
        System.out.println("rating1 = " + rating1);
        ls.add(bike);
        System.out.println("1st bike added");

        bike = new Bike();
        bike.setBikeImageSrc("/demo/2.Yezdi_Roadster.JPG");
        bike.setBikeName("Yezdi Roadster");
        bike.setBikePrice("Rs. 1.98 - 2.06 Lakh");
        bike.setBikeRatings(rating2);
        System.out.println("rating2 = " + rating2);
        ls.add(bike);

        bike = new Bike();
        bike.setBikeImageSrc("/demo/3.Jawa_42.JPG");
        bike.setBikeName("Jawa 42");
        bike.setBikePrice("Rs. 1.69 - 1.91 Lakh");
        bike.setBikeRatings(rating3);
        ls.add(bike);

        bike = new Bike();
        bike.setBikeImageSrc("/demo/4.Earth_Energy_EV_R.JPG");
        bike.setBikeName("Earth Energy EV Evolve");
        bike.setBikePrice("Rs. 1.42 Lakh");
        bike.setBikeRatings(rating4);
        ls.add(bike);

        bike = new Bike();
        bike.setBikeImageSrc("/demo/5.Cyborg_Yoda.JPG");
        bike.setBikeName("Cyborg Yoda");
        bike.setBikePrice("Rs. 1.84 Lakh");
        bike.setBikeRatings(rating5);
        ls.add(bike);

        bike = new Bike();
        bike.setBikeImageSrc("/demo/6.Honda_CBR_350RS.JPG");
        bike.setBikeName("Honda CBR 350RS");
        bike.setBikePrice("Rs. 2.03 Lakh");
        bike.setBikeRatings(rating6);
        ls.add(bike);

        bike = new Bike();
        bike.setBikeImageSrc("/demo/7.Jawa_Perek.JPG");
        bike.setBikeName("Jawa Perak");
        bike.setBikePrice("Rs. 2.06 Lakh");
        bike.setBikeRatings(rating7);
        ls.add(bike);

        bike = new Bike();
        bike.setBikeImageSrc("/demo/8.Royal_Enfield_Meteor_350.JPG");
        bike.setBikeName("Royal Enfield Meteor 350");
        bike.setBikePrice("Rs. 2.01 - 2.17 Lakh");
        bike.setBikeRatings(rating8);
        ls.add(bike);

        return ls;
    }

    public void setWelcomeLabel(String userName,int rating1, int rating2, int rating3, int rating4, int rating5, int rating6, int rating7,
                                int rating8){
        welcomeLabel.setText("Welcome " + userName);
        this.rating1 = rating1;
        System.out.println("In setWelcomeLabel() method: Rating1 = "+ rating1);
        this.rating2 = rating2;
        this.rating3 = rating3;
        this.rating4 = rating4;
        this.rating5 = rating5;
        this.rating6 = rating6;
        this.rating7 = rating7;
        this.rating8 = rating8;

        // Added the below code here because when initially used in initialize() it was getting called directly from "LoginController.java"
        // when declared using "CatalogueController catalogueController = loader.getController();" in loginAction() method. After that this method
        // "setWelcomeLabel" is called using constructor, therefore not showing correct fields in the "catalogue.fxml" files
        // This method is called in constructor when using method "catalogueController.setUserData(userEmail, password, receivedUserNameDB, receivedRating1, receivedRating2);"
        // which is called after initialize so therefore put this below code from initialize() to here. Now the problem is solved.
        recentlyAdded = new ArrayList<>(recentlyAdded());
        try {
           for (int i = 0; i < recentlyAdded.size(); i++) {
                System.out.println("Loop successfully started");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleBike.fxml"));
                VBox cardBox = fxmlLoader.load();
                BikeController bikeController = fxmlLoader.getController();
                bikeController.setData(recentlyAdded.get(i));
                bikesLayout.getChildren().add(cardBox);
           }
    } catch(IOException e) {
            System.out.println("Error in initialize()");
        e.printStackTrace();
    }

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

    @FXML
    void UserSaveInDBFunction(ActionEvent event) {
       Connection con = DBConnection.connect();
       PreparedStatement ps = null;
       updateBikeRatings(recentlyAdded);
       try{
           String sql = "UPDATE UserData set rating1 = ?, rating2 = ?, rating3 =  ?, rating4 = ?, rating5 = ?, rating6 = ?, rating7 = ?, rating8 = ? WHERE Email = ? ";
           ps = con.prepareStatement(sql);
           System.out.println("rating is as follows:" + rating1);
           System.out.println(email);
           ps.setString(1, rating1 + "");
           ps.setString(2, rating2 + "");
           ps.setString(3, rating3 + "");
           ps.setString(4, rating4 + "");
           ps.setString(5, rating5 + "");
           ps.setString(6, rating6 + "");
           ps.setString(7, rating7 + "");
           ps.setString(8, rating8 + "");
           ps.setString(9, email);
           ps.execute();
           System.out.println("DB has been updated");
       }
       catch (SQLException e){
           System.out.println("Some sql statement error during updation");
            System.out.println(e.toString());
       } finally {
        try {
            ps.close();
            con.close();
        } catch (SQLException e1) {
            System.out.println("Some closing error!");
            e1.printStackTrace();
        }

        }
    }

    // This method is used to update the local variables ratings so that it can be updated in DB as well.
 private void updateBikeRatings(List<Bike> bike){
     rating1 = bike.get(0).getBikeRatings();
     rating2 = bike.get(1).getBikeRatings();;
     rating3 = bike.get(2).getBikeRatings();;
     rating4 = bike.get(3).getBikeRatings();;
     rating5 = bike.get(4).getBikeRatings();;
     rating6 = bike.get(5).getBikeRatings();;
     rating7 = bike.get(6).getBikeRatings();;
     rating8 = bike.get(7).getBikeRatings();;
 }
}
