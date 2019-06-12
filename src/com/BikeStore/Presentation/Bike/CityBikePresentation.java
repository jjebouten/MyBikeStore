package com.BikeStore.Presentation.Bike;


import com.BikeStore.Data.Modal.BikeDefault;
import com.BikeStore.Logic.Bike.CityBikeLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CityBikePresentation extends BikeDefaultPresentation implements Initializable {

    private CityBikeLogic CityBikeLogic = new CityBikeLogic();

    @FXML
    private TableView<BikeDefault> tableView;
    @FXML
    private TableColumn<BikeDefault, Boolean> bikeBags;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeBikeDefaultFields();
        bikeBags.setCellValueFactory(new PropertyValueFactory<>("bikeBags"));
        tableView.getItems().setAll(CityBikeLogic.parseCityBikeList());
    }

}
