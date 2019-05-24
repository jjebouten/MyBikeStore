package com.BikeStore.Presentation.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Logic.Task.ShowTaskLogic;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskPresentation implements Initializable {

    private ShowTaskLogic showTaskLogic = new ShowTaskLogic();

    @FXML
    private TableView<Task> tableView;
    @FXML
    private TableColumn<Task, Integer> taskId;
    @FXML
    private TableColumn<Task, String> customerId;
    @FXML
    private TableColumn<Task, Integer> bikeId;
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
        bikeId.setCellValueFactory(new PropertyValueFactory<>("bikeId"));
        indication.setCellValueFactory(new PropertyValueFactory<>("indication"));
        taskDate.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        taskReadyDate.setCellValueFactory(new PropertyValueFactory<>("taskReadyDate"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        button.setCellFactory(ActionButtonTableCell.<Task>forTableColumn("Set Ready", (Task currentTask) -> {
            showTaskLogic.setTaskReadyDate(currentTask.getBikeId(), currentTask.getTaskId());
            reload();
            return null;
        }));
    }

    private void reload() {
        tableView.getItems().clear();
        tableView.getItems().setAll(showTaskLogic.parseTaskList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTaskFields();
        tableView.getItems().setAll(showTaskLogic.parseTaskList());
    }

}
