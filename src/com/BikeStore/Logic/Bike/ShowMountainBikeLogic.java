package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Repository.Bike.MountainBikeRepository;

import java.util.List;

public class ShowMountainBikeLogic {

    MountainBikeRepository mountainBikeRepository = new MountainBikeRepository();

    public List parseMountainBikeList() {
        return mountainBikeRepository.getAllMountainBikes();
    }
}
