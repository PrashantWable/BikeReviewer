package com.example.bikereviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class BikeController implements Initializable{
    @FXML
    private Label bikeName;

    @FXML
    private Label bikePrice;

    @FXML
    private Label singleBikeRating;

    @FXML
    private ImageView singleBikeImage;

    @FXML
    private Button decrementRating;

    @FXML
    private Button incrementRating;

    private int currentBikeRating;
    private Bike currentBike;


    public void setData(Bike bike) throws FileNotFoundException {
       // System.out.println("setData() method started");
        currentBike = bike;
        Image image = new Image(getClass().getResourceAsStream(bike.getBikeImageSrc()));
       // System.out.println("image set in between");
        singleBikeImage.setImage(image);
       // singleBikeImage.setImage(image);
     //   System.out.println("image set properly");
        singleBikeRating.setText("" + bike.getBikeRatings());
        currentBikeRating = bike.getBikeRatings();
        bikeName.setText(bike.getBikeName());
        bikePrice.setText(bike.getBikePrice());
        System.out.println("setData() method in BikeController worked properly!");
    }

    public void setRatingData(Bike bike) throws FileNotFoundException {
        bike.setBikeRatings(currentBikeRating);
        System.out.println("setRatingData() method in BikeController worked properly!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void decrementRatingFunction(ActionEvent event) throws FileNotFoundException {
       if(currentBikeRating>0){
           currentBikeRating = currentBikeRating-1;
       }
        singleBikeRating.setText("" + currentBikeRating);
        setRatingData(currentBike);
    }

    @FXML
    void incrementRatingFunction(ActionEvent event) throws FileNotFoundException {
        if(currentBikeRating<10){
            currentBikeRating = currentBikeRating+1;
        }
        singleBikeRating.setText("" + currentBikeRating);
        setRatingData(currentBike);
    }
}
