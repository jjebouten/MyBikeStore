package com.BikeStore.Logic.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Task.TaskRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskLogic extends TaskRepository {
    private Task task = new Task(null, null, null, "", "", "", "");
    private CustomerRepository customerRepository = new CustomerRepository();
    private BikeDefaultRepository bikeRepository = new BikeDefaultRepository();

    static String indicationReparation = "R";
    static String indicationDelivery = "A";
    static String descriptionDelivery = "Afleverbeurt";

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        return (dtf.format(localDate));
    }

    protected List parseTaskList() {
        return getAllTasks();
    }

    protected void setDateReady(Integer bikeId, Integer taskId) {
        setDateLastTaskOnBike(bikeId, getCurrentDate());
        setDateLastTaskOnTask(taskId, getCurrentDate());
    }

    public void setDateLastTaskOnBike(Integer bikeId, String currentDate) {
        bikeRepository.setDateLastTask(bikeId, currentDate);
    }

    private void setDateLastTaskOnTask(Integer taskId, String currentDate) {
        setTaskReadyDate(taskId, currentDate);
    }

    protected boolean createNewReparationTask(Integer customerId, Integer bikeId, String description) {
        if (customerId != null && bikeId != null) {
            return newTaskDefault(customerId, bikeId, description, indicationReparation);
        }
        return false;
    }

    protected boolean createNewDeliveryTask(Integer customerId, Integer bikeId) {
        if (customerId != null && bikeId != null) {
            return newTaskDefault(customerId, bikeId, descriptionDelivery, indicationDelivery);
        }
        return false;
    }

    private boolean newTaskDefault(Integer customerId, Integer bikeId, String description, String indicationReparation) {
        task.setTaskId(createNewTaskId());
        task.setCustomer(customerRepository.getCustomerById(customerId));
        task.setBike(bikeRepository.getBikeById(bikeId));
        task.setDescription(description);
        task.setIndication(indicationReparation);
        task.setTaskDate(getCurrentDate());
        newTask(task);
        return true;
    }

    private int createNewTaskId() {
        return (getMaxTaskId() + 1);
    }

    protected ObservableList getAllCustomerIdsInObservableList() {
        return FXCollections.observableArrayList(getAllCustomerIds());
    }

    protected ObservableList getAllBikeIdsInObservableList() {
        return FXCollections.observableArrayList(getAllBikeIds());
    }

}
