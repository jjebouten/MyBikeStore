package com.BikeStore.Presentation.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Logic.Task.TaskLogic;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;

public class TaskPresentation extends TaskLogic implements Initializable {

    @FXML
    private TableView<Task> tableView;
    @FXML
    private TableColumn<Task, Integer> taskId;
    @FXML
    private TableColumn<Task, String> customerId;
    @FXML
    private TableColumn<Task, String> bikeId;
    @FXML
    private TableColumn<Task, Integer> indication;
    @FXML
    private TableColumn<Task, String> taskDate;
    @FXML
    private TableColumn<Task, String> taskReadyDate;
    @FXML
    private TableColumn<Task, String> description;
    @FXML
    private TableColumn<Task, Button> button;


    private void initializeTaskFields() {
        taskId.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        customerId.setCellValueFactory(cellData ->
                new SimpleStringProperty((String.valueOf(cellData.getValue().getCustomer().getCustomerId()))));
        bikeId.setCellValueFactory(cellData ->
                new SimpleStringProperty((String.valueOf(cellData.getValue().getBike().getBikeId()))));
        indication.setCellValueFactory(new PropertyValueFactory<>("indication"));
        taskDate.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        taskReadyDate.setCellValueFactory(new PropertyValueFactory<>("taskReadyDate"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        button.setCellFactory(ActionButtonTableCell.forTableColumn("Set Ready", (Task currentTask) -> {
            setDateReady(currentTask.getBike().getBikeId(), currentTask.getTaskId());
            reload();
            return null;
        }));
    }

    private void reload() {
        tableView.getItems().clear();
        tableView.getItems().setAll(parseTaskList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTaskFields();
        if (parseTaskList().size() > 0) {
            tableView.getItems().setAll(parseTaskList());
        } else {
            alertError("Error 1558345465", "Something went wrong, Could not fetch results");
        }
    }

}
