package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;

public class BikeValidationLogic {

    private BikeDefaultRepository bikeDefaultRepository = new BikeDefaultRepository();

    public boolean CheckIfBikeIdExists(int bikeId) {
        return bikeDefaultRepository.checkIfIdExistsInDatabase(bikeId);
    }

}
