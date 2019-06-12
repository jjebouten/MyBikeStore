package com.BikeStore.Presentation.Task;

import com.BikeStore.Logic.Task.TaskLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.Optional;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;
import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;
import static com.FieldValidator.FieldValidator.isNullOrEmptyString;

public class TaskExportPresentation extends TaskLogic {

    @FXML
    public ComboBox selectSorting;

    public void printAllTasks(ActionEvent actionEvent) {
        String sortingField = Optional.ofNullable((String) selectSorting.getValue()).orElse("");
        if (validateSortingIsTrue(sortingField)) {
            alertSucces("All tasks will be exported", "Sorted on " + sortingField);
            exportAllTasks(sortingField);
        }
    }


    private boolean validateSortingIsTrue(String sortingField) {
        if (isNullOrEmptyString(sortingField)) {
            alertError("Error 1558099982", "No sorting field given");
            return false;
        } else return true;
    }
}
