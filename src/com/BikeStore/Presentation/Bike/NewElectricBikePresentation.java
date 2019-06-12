package com.BikeStore.Presentation.Bike;

import com.BikeStore.Logic.Bike.ElectricBikeLogic;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewElectricBikePresentation extends NewBikeDefaultPresentation {

    private ElectricBikeLogic newElectricBikeLogic = new ElectricBikeLogic();

    @FXML
    public TextField txtPower;

    public void registerNewElectricBike() {
        if (validateBikeDefaultFields(
                txtBikeId.getText(),
                txtBikeBrand.getText(),
                txtRimSize.getText(), txtNumberOfGears.getText()) && validateElectricBikePower(txtPower.getText())) {
            newElectricBikeLogic.createNewElectricBike(txtBikeId.getText(),
                    txtBikeBrand.getText(),
                    txtRimSize.getText(),
                    txtNumberOfGears.getText(),
                    txtPower.getText());
            alertSucces("Succes", "ElectricBike succesfully created");
            txtBikeId.setText("");
            txtBikeBrand.setText("");
            txtRimSize.setText("");
            txtNumberOfGears.setText("");
            txtPower.setText("");
        }
    }
}
