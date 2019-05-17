package com.BikeStore.Data.Repository.Bike;

public class BikeTypeRepository {
    public String parseBikeType(int bikeType) {
        String type = "";
        switch (bikeType) {
            case 1:
                type = "City Bike";
            case 2:
                type = "Electric Bike";
            case 3:
                type = "Mountain Bike";
            default:
                type = "Error: Code (1557481029) No correct bike Type given";
        }
        return type;
    }
}
