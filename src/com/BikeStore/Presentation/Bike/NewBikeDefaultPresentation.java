package com.BikeStore.Presentation.Bike;


import com.BikeStore.Logic.Bike.BikeValidationLogic;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;
import static com.FieldValidator.FieldValidator.*;

class NewBikeDefaultPresentation {

    private BikeValidationLogic bikeValidationLogic = new BikeValidationLogic();

    @FXML
    public TextField txtBikeId;
    @FXML
    public TextField txtBikeBrand;
    @FXML
    public TextField txtRimSize;
    @FXML
    public TextField txtNumberOfGears;

    boolean validateBikeDefaultFields(String bikeId, String bikeBrand, String rimSize, String numberOfGears) {

        if (!StringIsInteger(bikeId)) {
            alertError("Error 1558095938", "Bike Id should only be a number");
            return false;
        }

        if (!StringIsInteger(numberOfGears)) {
            alertError("Error 1558095938", "numberOfGears should only be a number");
            return false;
        }

        if (bikeValidationLogic.CheckIfBikeIdExists(Integer.parseInt(bikeId))) {
            alertError("Error 1558094847", "Bike Id already exists in database");
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

    boolean validateMountainBikeSuspension(String bikeSuspension) {
        if (bikeSuspension.equals("Hardtail") || bikeSuspension.equals("Full-suspension")) {
            return true;
        }
        alertError("Error 1558357900", "Invalid Suspension Value \n has to be Hardtail or Full-suspension");
        return false;
    }

    boolean validateElectricBikePower(String power) {
        if (!StringIsDouble(power)) {
            alertError("Error 1558356504", "Invalid Power please enter \n positive double (20.6) for example");
            return false;
        }
        return true;
    }

}
