package com.BikeStore.Presentation.Bike;

import com.BikeStore.Logic.Bike.MountainBikeLogic;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.Optional;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewMountainBikePresentation extends NewBikeDefaultPresentation {

    private MountainBikeLogic newMountainBikeLogic = new MountainBikeLogic();

    @FXML
    public ComboBox selectBikeSuspension;

    public void registerNewMountainBike() {
        if (validateBikeDefaultFields(
                txtBikeId.getText(),
                txtBikeBrand.getText(),
                txtRimSize.getText(), txtNumberOfGears.getText()) && validateMountainBikeSuspension(Optional.ofNullable((String)selectBikeSuspension.getValue()).orElse(""))) {
            newMountainBikeLogic.createNewMountainBike(txtBikeId.getText(),
                    txtBikeBrand.getText(),
                    txtRimSize.getText(),
                    txtNumberOfGears.getText(),
                    (String) selectBikeSuspension.getValue());
            alertSucces("Succes", "MountainBike succesfully created");
            txtBikeId.setText("");
            txtBikeBrand.setText("");
            txtRimSize.setText("");
            txtNumberOfGears.setText("");
        }
    }
}