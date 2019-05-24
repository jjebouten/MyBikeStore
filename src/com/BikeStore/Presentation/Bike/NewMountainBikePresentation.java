package com.BikeStore.Presentation.Bike;

import com.BikeStore.Logic.Bike.NewMountainBikeLogic;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewMountainBikePresentation {

    private NewMountainBikeLogic newMountainBikeLogic = new NewMountainBikeLogic();

    @FXML
    public TextField txtBikeId;
    @FXML
    public TextField txtBikeBrand;
    @FXML
    public TextField txtRimSize;
    @FXML
    public TextField txtNumberOfGears;
    @FXML
    public ComboBox selectBikeSuspension;

    public void registerNewMountainBike() {
        if (newMountainBikeLogic.createNewMountainBike(txtBikeId.getText(),
                txtBikeBrand.getText(),
                txtRimSize.getText(),
                txtNumberOfGears.getText(),
                (String) selectBikeSuspension.getValue())) {
            alertSucces("Succes", "MountainBike succesfully created");
            txtBikeId.setText("");
            txtBikeBrand.setText("");
            txtRimSize.setText("");
            txtNumberOfGears.setText("");
        }
    }
}
