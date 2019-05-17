package com.BikeStore.Data.Modal;

import java.util.Date;

public class ElectricBike extends BikeDefault {
    private double power;

    public ElectricBike(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, Date dateLastTask, double power) {
        super(bikeId, bikeBrand, bikeType, rimSize, numberOfGears, dateLastTask);
        this.power = power;
    }

    public double getPower() {
        return power;
    }
}
