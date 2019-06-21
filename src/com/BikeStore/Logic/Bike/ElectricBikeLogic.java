package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.ElectricBike;
import com.BikeStore.Data.Repository.Bike.ElectricBikeRepository;

import java.util.List;


public class ElectricBikeLogic {

    private ElectricBikeRepository electricBikeRepository = new ElectricBikeRepository();

    private final String bikeType = "ElectricBike";
    private ElectricBike electricBike = new ElectricBike(0, "", "", 0.0, 0, "", 0.0);

    public void createNewElectricBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String power) {
        electricBike.setBikeId(Integer.parseInt(bikeId));
        electricBike.setBikeBrand(bikeBrand);
        electricBike.setBikeType(bikeType);
        electricBike.setRimSize(Double.parseDouble(rimSize));
        electricBike.setNumberOfGears(Integer.parseInt(numberOfGears));
        electricBike.setPower(Double.parseDouble(power));
        electricBikeRepository.createNew(electricBike);
    }

    public List parseElectricBikeList() {
        return electricBikeRepository.getAll();
    }

}
