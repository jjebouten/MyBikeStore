package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Repository.Bike.ElectricBikeRepository;

import java.util.List;

public class ShowElectricBikeLogic {

    ElectricBikeRepository electricBikeRepository = new ElectricBikeRepository();

    public List parseElectricBikeList() {
        return electricBikeRepository.getAllElectricBikes();
    }

}
