package com.BikeStore.Presentation.Bike;


import com.BikeStore.Data.Modal.BikeDefault;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

class BikeDefaultPresentation {

    @FXML
    private TableColumn<BikeDefault, Integer> bikeId;
    @FXML
    private TableColumn<BikeDefault, String> bikeBrand;
    @FXML
    private TableColumn<BikeDefault, Integer> bikeType;
    @FXML
    private TableColumn<BikeDefault, Double> rimSize;
    @FXML
    private TableColumn<BikeDefault, Integer> numberOfGears;
    @FXML
    private TableColumn<BikeDefault, Date> dateLastTask;

    void initializeBikeDefaultFields() {
        bikeId.setCellValueFactory(new PropertyValueFactory<>("bikeId"));
        bikeBrand.setCellValueFactory(new PropertyValueFactory<>("bikeBrand"));
        bikeType.setCellValueFactory(new PropertyValueFactory<>("bikeType"));
        rimSize.setCellValueFactory(new PropertyValueFactory<>("rimSize"));
        numberOfGears.setCellValueFactory(new PropertyValueFactory<>("numberOfGears"));
        dateLastTask.setCellValueFactory(new PropertyValueFactory<>("dateLastTask"));
    }

}
