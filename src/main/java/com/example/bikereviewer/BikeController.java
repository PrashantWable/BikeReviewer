package com.example.bikereviewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
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


    public void setData(Bike bike) throws FileNotFoundException {
       // System.out.println("setData() method started");
        Image image = new Image(getClass().getResourceAsStream(bike.getBikeImageSrc()));
       // System.out.println("image set in between");
        singleBikeImage.setImage(image);
       // singleBikeImage.setImage(image);
        System.out.println("image set properly");
        //singleBikeRating.setText(bike.getBikeName());
        bikeName.setText(bike.getBikeName());
        bikePrice.setText(bike.getBikePrice());
        System.out.println("setData() method in BikeController worked properly!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
