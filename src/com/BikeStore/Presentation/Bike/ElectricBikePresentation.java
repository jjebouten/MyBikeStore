package com.BikeStore.Presentation.Bike;

import com.BikeStore.Data.Modal.BikeDefault;
import com.BikeStore.Logic.Bike.ElectricBikeLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ElectricBikePresentation extends BikeDefaultPresentation implements Initializable {

    private ElectricBikeLogic electricBikeLogic = new ElectricBikeLogic();

    @FXML
    private TableView<BikeDefault> tableView;
    @FXML
    private TableColumn<BikeDefault, Double> power;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeBikeDefaultFields();
        power.setCellValueFactory(new PropertyValueFactory<>("power"));
        tableView.getItems().setAll(electricBikeLogic.parseElectricBikeList());
    }

}
