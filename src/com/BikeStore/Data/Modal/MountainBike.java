package com.BikeStore.Data.Modal;

import java.util.Date;

public class MountainBike extends BikeDefault {

    private String suspension;

    public MountainBike(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, Date dateLastTask, String suspension) {
        super(bikeId, bikeBrand, bikeType, rimSize, numberOfGears, dateLastTask);
        this.suspension = suspension;
    }

    public String getSuspension() {
        return suspension;
    }
}
