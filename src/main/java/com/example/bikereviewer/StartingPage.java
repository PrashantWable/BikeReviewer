package com.example.bikereviewer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartingPage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/demo/icon.png")));
        stage.setResizable(false);
        stage.show();

//        stage.setOnCloseRequest(e -> {
//            e.consume();
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Logging out");
//            alert.setHeaderText("You're about to logout!");
//            alert.setContentText("Do you want to save before exiting?:");
//
//            if(alert.showAndWait().get() == ButtonType.OK){
//                stage = (Stage) catalogueAnchorPane.getScene().getWindow();
//                stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//                System.out.println("You have successfully logged out!");
//                stage.close();
//            }
//        });
    }

    public static void main(String[] args) {
        launch();
    }

}