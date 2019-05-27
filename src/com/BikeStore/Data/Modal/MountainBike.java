package com.BikeStore.Data.Modal;

public class MountainBike extends BikeDefault {

    private String suspension;

    public MountainBike(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, String dateLastTask, String suspension) {
        super(bikeId, bikeBrand, bikeType, rimSize, numberOfGears, dateLastTask);
        this.suspension = suspension;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }
}
