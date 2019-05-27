package com.BikeStore.Data.Modal;

public abstract class BikeDefault implements BikeInterface {
    private int bikeId;
    private String bikeBrand;
    private String bikeType;
    private double rimSize;
    private int numberOfGears;
    private String dateLastTask;

    public BikeDefault(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, String dateLastTask) {
        this.bikeId = bikeId;
        this.bikeBrand = bikeBrand;
        this.bikeType = bikeType;
        this.rimSize = rimSize;
        this.numberOfGears = numberOfGears;
        this.dateLastTask = dateLastTask;
    }

    @Override
    public int getBikeId() {
        return bikeId;
    }

    @Override
    public String getBikeBrand() {
        return bikeBrand;
    }

    @Override
    public String getBikeType() {
        return bikeType;
    }

    @Override
    public double getRimSize() {
        return rimSize;
    }

    @Override
    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public String getDateLastTask() {
        return dateLastTask;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public void setBikeBrand(String bikeBrand) {
        this.bikeBrand = bikeBrand;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public void setRimSize(double rimSize) {
        this.rimSize = rimSize;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

}
