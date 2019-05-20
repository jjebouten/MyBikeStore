package com.BikeStore.Presentation.Bike;

import com.BikeStore.Logic.Bike.NewCityBikeLogic;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewCityBikePresentation {

    private NewCityBikeLogic newCityBikeLogic = new NewCityBikeLogic();

    @FXML
    public TextField txtBikeId;
    @FXML
    public TextField txtBikeBrand;
    @FXML
    public TextField txtRimSize;
    @FXML
    public TextField txtNumberOfGears;
    @FXML
    public CheckBox cbxBikeBags;


    public void registerNewCityBike() {
        if (newCityBikeLogic.createNewCityBike(txtBikeId.getText(),
                txtBikeBrand.getText(),
                txtRimSize.getText(),
                txtNumberOfGears.getText(),
                String.valueOf(cbxBikeBags.isSelected()))) {
            alertSucces("Succes", "CityBike succesfully created");
            txtBikeId.setText("");
            txtBikeBrand.setText("");
            txtRimSize.setText("");
            txtNumberOfGears.setText("");
            cbxBikeBags.setSelected(false);
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
