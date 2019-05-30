package com.BikeStore.Data.Modal;

public class ElectricBike extends BikeDefault {
    private double power;

    public ElectricBike(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, String dateLastTask, double power) {
        super(bikeId, bikeBrand, bikeType, rimSize, numberOfGears, dateLastTask);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
