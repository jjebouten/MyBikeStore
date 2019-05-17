package com.BikeStore.Data.Modal;

import java.util.Date;

public abstract class BikeDefault implements BikeInterface {
    private int bikeId;
    private String bikeBrand;
    private String bikeType;
    private double rimSize;
    private int numberOfGears;
    private Date dateLastTask;

    public BikeDefault(int bikeId, String bikeBrand, String bikeType, double rimSize, int numberOfGears, Date dateLastTask) {
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
    public Date getDateLastTask() {
        return dateLastTask;
    }
}
