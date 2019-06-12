package com.BikeStore.Presentation.Task;

import com.BikeStore.Logic.Task.TaskLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;
import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertWarning;

public class NewTaskReparationPresentation extends TaskLogic implements Initializable {

    @FXML
    private ComboBox cmbCustomer;
    @FXML
    private ComboBox cmbBike;
    @FXML
    private TextArea txtDescription;

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
        } else {
            alertWarning("Error 1558707296", "Invalid customerId or BikeId");
        }
    }

}
