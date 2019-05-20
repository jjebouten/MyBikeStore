package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Modal.ElectricBike;
import com.BikeStore.Data.Repository.Bike.ElectricBikeRepository;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;
import static com.FieldValidator.FieldValidator.StringIsDouble;


public class NewElectricBikeLogic {

    ElectricBikeRepository electricBikeRepository = new ElectricBikeRepository();
    NewBikeDefaultLogic newBikeDefaultLogic = new NewBikeDefaultLogic();
    private static String bikeType = "ElectricBike";
    private ElectricBike electricBike = new ElectricBike(0, "", "", 0.0, 0, "", 0.0);

    public boolean createNewElectricBike(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String power) {

        if (!validateElectricBikePower(power)) {
            return false;
        }

        if (newBikeDefaultLogic.validateBikeDefaultFields(bikeId, bikeBrand, rimSize, numberOfGears)) {
            electricBike.setBikeId(Integer.parseInt(bikeId));
            electricBike.setBikeBrand(bikeBrand);
            electricBike.setBikeType(bikeType);
            electricBike.setRimSize(Double.parseDouble(rimSize));
            electricBike.setNumberOfGears(Integer.parseInt(numberOfGears));
            electricBike.setPower(Double.parseDouble(power));

            electricBikeRepository.newElectricBike(electricBike);
            return true;
        }
        return false;
    }

    private boolean validateElectricBikePower(String power) {

        if (!StringIsDouble(power)) {
            alertError("Error 1558356504", "Invalid Power please enter \n positive double (20.6) for example");
            return false;
        }
        return true;
    }
}
