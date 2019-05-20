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
//            selectBikeSuspension.setValue(1);
        }
    }

//    private void setupForDateField() {
//        dpDateLastTask.setConverter(new StringConverter<LocalDate>() {
//            String pattern = "yyyy-MM-dd";
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
//
//            {
//                dpDateLastTask.setPromptText(pattern.toLowerCase());
//            }
//
//            @Override
//            public String toString(LocalDate date) {
//                if (date != null) {
//                    return dateFormatter.format(date);
//                } else {
//                    return "";
//                }
//            }
//
//            @Override
//            public LocalDate fromString(String string) {
//                if (string != null && !string.isEmpty()) {
//                    return LocalDate.parse(string, dateFormatter);
//                } else {
//                    return null;
//                }
//            }
//        });
//    }
}
