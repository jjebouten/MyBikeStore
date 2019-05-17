package com.BikeStore.Logic.Bike;


import com.BikeStore.Data.Repository.Bike.CityBikeRepository;

import java.util.List;

public class ShowCityBikeLogic {

    CityBikeRepository cityBikeRepository = new CityBikeRepository();

    public List parseCityBikeList() {
        return cityBikeRepository.getAllCityBikes();
    }

}
