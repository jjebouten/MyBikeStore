package com.BikeStore.Presentation.Bike;

import com.BikeStore.Data.Modal.BikeDefault;
import com.BikeStore.Data.Modal.MountainBike;
import com.BikeStore.Logic.Bike.MountainBikeLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;

public class MountainBikePresentation extends BikeDefaultPresentation implements Initializable {

    private MountainBikeLogic mountainBikeLogic = new MountainBikeLogic();

    @FXML
    private TableView<MountainBike> tableView;
    @FXML
    private TableColumn<BikeDefault, String> suspension;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeBikeDefaultFields();
        suspension.setCellValueFactory(new PropertyValueFactory<>("suspension"));
        if (mountainBikeLogic.parseMountainBikeList().size() > 0) {
            tableView.getItems().setAll(mountainBikeLogic.parseMountainBikeList());
        } else {
            alertError("Error 1558345465", "Something went wrong, Could not fetch results");
        }
    }

}
