package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.CityBike;
import com.BikeStore.Data.Repository.Bike.CityBikeRepository;


public class NewCityBikeLogic {

    CityBikeRepository cityBikeRepository = new CityBikeRepository();
    NewBikeDefaultLogic newBikeDefaultLogic = new NewBikeDefaultLogic();
    private static String bikeType = "CityBike";
    private CityBike cityBike = new CityBike(0, "", "", 0.0, 0, "", "");

    public boolean createNewCityBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String bikeBags) {

        if (newBikeDefaultLogic.validateBikeDefaultFields(bikeId, bikeBrand, rimSize, numberOfGears)) {

            cityBike.setBikeId(Integer.parseInt(bikeId));
            cityBike.setBikeBrand(bikeBrand);
            cityBike.setBikeType(bikeType);
            cityBike.setRimSize(Double.parseDouble(rimSize));
            cityBike.setNumberOfGears(Integer.parseInt(numberOfGears));
            cityBike.setBikeBags(bikeBags);


            cityBikeRepository.newCityBike(cityBike);
            return true;
        }
        return false;
    }
}
