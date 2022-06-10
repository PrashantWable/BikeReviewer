package com.example.bikereviewer;

public class Bike {
    private String bikeName;
    private String bikeImageSrc;
    private int bikeRatings;
    private String bikePrice;

    public String getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(String bikePrice) {
        this.bikePrice = bikePrice;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBikeImageSrc() {
        return bikeImageSrc;
    }

    public void setBikeImageSrc(String bikeImageSrc) {
        this.bikeImageSrc = bikeImageSrc;
    }

    public int getBikeRatings() {
        return bikeRatings;
    }

    public void setBikeRatings(int bikeRatings) {
       this.bikeRatings = bikeRatings;
    }
}
