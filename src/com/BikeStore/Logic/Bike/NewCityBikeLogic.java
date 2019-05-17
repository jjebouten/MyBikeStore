package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.CityBike;
import com.BikeStore.Data.Repository.Bike.CityBikeRepository;


public class NewCityBikeLogic {

    CityBikeRepository cityBikeRepository = new CityBikeRepository();
    NewBikeDefaultLogic newBikeDefaultLogic = new NewBikeDefaultLogic();
    private static String bikeType = "CityBike";

    public boolean createNewCityBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String dateLastTask, String bikeBags) {

        if (newBikeDefaultLogic.validateBikeDefaultFields(bikeId, bikeBrand, rimSize, numberOfGears, dateLastTask)) {
            CityBike cityBike = new CityBike(Integer.parseInt(bikeId), bikeBrand, bikeType, Double.parseDouble(rimSize), Integer.parseInt(numberOfGears), dateLastTask, bikeBags);
            cityBikeRepository.newCityBike(cityBike);
            return true;
        }
        return false;
    }
}
