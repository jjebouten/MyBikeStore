package com.BikeStore.Data.Modal;


public class CityBike extends BikeDefault {
    private String bikeBags;

    public CityBike(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, String dateLastTask, String bikeBags) {
        super(bikeId, bikeBrand, bikeType, rimSize, numberOfGears, dateLastTask);
        this.bikeBags = bikeBags;
    }

    public String getBikeBags() {
        return bikeBags;
    }

    public void setBikeBags(String bikeBags) {
        this.bikeBags = bikeBags;
    }
}


