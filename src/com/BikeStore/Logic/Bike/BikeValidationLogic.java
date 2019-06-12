package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;

public class BikeValidationLogic extends BikeDefaultRepository {

    public boolean CheckIfBikeIdExists(int bikeId) {
        return CheckIfIdExistsInDatabase(bikeId);
    }

}
