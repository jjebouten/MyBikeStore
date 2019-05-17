package com.BikeStore.Data.Modal;

import java.util.Date;

public class CityBike extends BikeDefault {
    private String bikeBags;

    public CityBike(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, Date dateLastTask, String bikeBags) {
        super(bikeId, bikeBrand, bikeType, rimSize, numberOfGears, dateLastTask);
        this.bikeBags = bikeBags;
    }

    public String getBikeBags() {
        return bikeBags;
    }
}


