package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.MountainBike;
import com.BikeStore.Data.Repository.Bike.MountainBikeRepository;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;


public class NewMountainBikeLogic extends NewBikeDefaultLogic {

    MountainBikeRepository mountainBikeRepository = new MountainBikeRepository();

    private static String bikeType = "MountainBike";
    private MountainBike mountainBike = new MountainBike(0, "", "", 0.0, 0, "", "");

    public boolean createNewMountainBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String bikeSuspension) {

        if (!validateMountainBikeSuspension(bikeSuspension)) {
            return false;
        }

        if (validateBikeDefaultFields(bikeId, bikeBrand, rimSize, numberOfGears)) {
            mountainBike.setBikeId(Integer.parseInt(bikeId));
            mountainBike.setBikeBrand(bikeBrand);
            mountainBike.setBikeType(bikeType);
            mountainBike.setRimSize(Double.parseDouble(rimSize));
            mountainBike.setNumberOfGears(Integer.parseInt(numberOfGears));
            mountainBike.setSuspension(bikeSuspension);

            mountainBikeRepository.newMountainBike(mountainBike);
            return true;
        }
        return false;
    }

    private boolean validateMountainBikeSuspension(String bikeSuspension) {
        if (bikeSuspension.equals("Hardtail") || bikeSuspension.equals("Full-suspension")) {
            return true;
        }
        alertError("Error 1558357900", "Invalid Suspension Value \n has to be Hardtail or Full-suspension");
        return false;
    }
}
