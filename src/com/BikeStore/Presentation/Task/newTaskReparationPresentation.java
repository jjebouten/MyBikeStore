package com.BikeStore.Presentation.Task;

import com.BikeStore.Logic.Task.NewTaskReparationLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class newTaskReparationPresentation extends NewTaskReparationLogic implements Initializable {

    @FXML
    public ComboBox cmbCustomer;
    @FXML
    public ComboBox cmbBike;
    @FXML
    public TextArea txtDescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCustomer.getItems().clear();
        cmbCustomer.getItems().addAll(getAllCustomerIdsInObservableList());
        cmbBike.getItems().clear();
        cmbBike.getItems().addAll(getAllBikeIdsInObservableList());
    }

    public void btnCreateNewReparationTask() {
        Integer customerId = (Integer) cmbCustomer.getValue();
        Integer bikeId = (Integer) cmbBike.getValue();
        String description = txtDescription.getText();
        if (createNewReparationTask(customerId, bikeId, description)) {
            alertSucces("Succes", "Reparation task succesfully created");
            cmbCustomer.setValue(0);
            cmbBike.setValue(0);
            txtDescription.setText("");
        }
    }

}