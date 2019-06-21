package com.BikeStore.Presentation.Task;

import com.BikeStore.Logic.Task.TaskLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;
import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertWarning;

public class NewTaskDeliveryPresentation implements Initializable {

    private TaskLogic taskLogic = new TaskLogic();

    @FXML
    private ComboBox cmbCustomer;
    @FXML
    private ComboBox cmbBike;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCustomer.getItems().clear();
        cmbCustomer.getItems().addAll(taskLogic.getAllCustomerIdsInObservableList());
        cmbBike.getItems().clear();
        cmbBike.getItems().addAll(taskLogic.getAllBikeIdsInObservableList());
    }

    public void btnCreateNewDeliveryTask() {
        Integer customerId = (Integer) cmbCustomer.getValue();
        Integer bikeId = (Integer) cmbBike.getValue();
        if (taskLogic.createNewDeliveryTask(customerId, bikeId)) {
            alertSucces("Succes", "Delivery task succesfully created");
            cmbCustomer.setValue(0);
            cmbBike.setValue(0);
        }
        else {
            alertWarning("Error 1558707337", "Invalid customerId or BikeId");
        }
    }

}
