package com.BikeStore.Logic.Bike;

import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;
import static com.FieldValidator.FieldValidator.*;

public class NewBikeDefaultLogic {

    BikeDefaultRepository bikeDefaultRepository = new BikeDefaultRepository();

    public boolean validateBikeDefaultFields(String bikeId, String bikeBrand, String rimSize, String numberOfGears, String dateLastTask) {

        if (!StringIsInteger(bikeId)) {
            alertError("Error 1558095938", "Bike Id should only be a number");
            return false;
        }

        if (!StringIsInteger(numberOfGears)) {
            alertError("Error 1558095938", "numberOfGears should only be a number");
            return false;
        }

        if (bikeDefaultRepository.CheckIfIdExistsInDatabase(Integer.parseInt(bikeId))) {
            alertError("Error 1558094847", "Bike Id already exists in database");
            return false;
        }

        if (!isThisDateValid(dateLastTask)) {
            alertError("Error 1558099386", "Invalid date");
            return false;
        }

        if (isNullOrEmptyString(bikeBrand)) {
            alertError("Error 1558094753", "Invalid input all fields are required");
            return false;
        }

        if (!StringIsDouble(rimSize)) {
            alertError("Error 1558095800", "Invalid Rimsize please enter \n positive double (20.6) for example");
            return false;
        }

        if (!isPositiveInteger(Integer.parseInt(numberOfGears))) {
            alertError("Error 1558095340", "Invalid numberOfGears please enter positive number");
            return false;
        }
        return true;
    }

}
