package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.MountainBike;
import com.BikeStore.Data.Repository.Bike.MountainBikeRepository;

import java.util.List;


public class MountainBikeLogic extends MountainBikeRepository {

    private static String bikeType = "MountainBike";
    private MountainBike mountainBike = new MountainBike(0, "", "", 0.0, 0, "", "");

    public void createNewMountainBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String bikeSuspension) {
        mountainBike.setBikeId(Integer.parseInt(bikeId));
        mountainBike.setBikeBrand(bikeBrand);
        mountainBike.setBikeType(bikeType);
        mountainBike.setRimSize(Double.parseDouble(rimSize));
        mountainBike.setNumberOfGears(Integer.parseInt(numberOfGears));
        mountainBike.setSuspension(bikeSuspension);
        createNewMountain(mountainBike);
    }

    public List parseMountainBikeList() {
        return getAllMountainBikes();
    }

}
