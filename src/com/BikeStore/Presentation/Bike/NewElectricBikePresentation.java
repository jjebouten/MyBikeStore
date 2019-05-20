package com.BikeStore.Presentation.Bike;

import com.BikeStore.Logic.Bike.NewElectricBikeLogic;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewElectricBikePresentation {

    private NewElectricBikeLogic newElectricBikeLogic = new NewElectricBikeLogic();

    @FXML
    public TextField txtBikeId;
    @FXML
    public TextField txtBikeBrand;
    @FXML
    public TextField txtRimSize;
    @FXML
    public TextField txtNumberOfGears;
    @FXML
    public TextField txtPower;


    public void registerNewElectricBike() {
        if (newElectricBikeLogic.createNewElectricBike(txtBikeId.getText(),
                txtBikeBrand.getText(),
                txtRimSize.getText(),
                txtNumberOfGears.getText(),
                txtPower.getText())) {
            alertSucces("Succes", "ElectricBike succesfully created");
            txtBikeId.setText("");
            txtBikeBrand.setText("");
            txtRimSize.setText("");
            txtNumberOfGears.setText("");
            txtPower.setText("");
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
