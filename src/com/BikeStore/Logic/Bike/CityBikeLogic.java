package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.CityBike;
import com.BikeStore.Data.Repository.Bike.CityBikeRepository;

import java.util.List;


public class CityBikeLogic extends CityBikeRepository {

    private static String bikeType = "CityBike";
    private CityBike cityBike = new CityBike(0, "", "", 0.0, 0, "", "");

    public void createNewCityBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String bikeBags) {
        cityBike.setBikeId(Integer.parseInt(bikeId));
        cityBike.setBikeBrand(bikeBrand);
        cityBike.setBikeType(bikeType);
        cityBike.setRimSize(Double.parseDouble(rimSize));
        cityBike.setNumberOfGears(Integer.parseInt(numberOfGears));
        cityBike.setBikeBags(bikeBags);
        createNewCityBike(cityBike);
    }

    public List parseCityBikeList() {
        return getAllCityBikes();
    }

}
