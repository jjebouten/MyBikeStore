package com.BikeStore.Presentation.Bike;

import com.BikeStore.Logic.Bike.CityBikeLogic;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewCityBikePresentation extends NewBikeDefaultPresentation {

    private CityBikeLogic newCityBikeLogic = new CityBikeLogic();

    @FXML
    public CheckBox cbxBikeBags;

    public void registerNewCityBike() {
        if (validateBikeDefaultFields(
                txtBikeId.getText(),
                txtBikeBrand.getText(),
                txtRimSize.getText(), txtNumberOfGears.getText()))
        {
            newCityBikeLogic.createNewCityBike(txtBikeId.getText(),
                    txtBikeBrand.getText(),
                    txtRimSize.getText(),
                    txtNumberOfGears.getText(),
                    String.valueOf(cbxBikeBags.isSelected())
            );

            alertSucces("Succes", "CityBike succesfully created");
            txtBikeId.setText("");
            txtBikeBrand.setText("");
            txtRimSize.setText("");
            txtNumberOfGears.setText("");
            cbxBikeBags.setSelected(false);
        }
    }

}
