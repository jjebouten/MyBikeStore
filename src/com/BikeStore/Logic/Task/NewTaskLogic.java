package com.BikeStore.Logic.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Task.TaskRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewTaskLogic extends TaskRepository {

    static String indicationReparation = "R";
    static String indicationDelivery = "A";
    static String descriptionDelivery = "Afleverbeurt";

    Task task = new Task(null, null, null, "", "", "", "");
    CustomerRepository customerRepository = new CustomerRepository();

    public boolean createNewReparationTask(Integer customerId, Integer bikeId, String description) {
        return newTaskDefault(customerId, bikeId, description, indicationReparation);
    }

    public boolean createNewDeliveryTask(Integer customerId, Integer bikeId) {
        return newTaskDefault(customerId, bikeId, descriptionDelivery, indicationDelivery);
    }

    private boolean newTaskDefault(Integer customerId, Integer bikeId, String description, String indicationReparation) {
        task.setTaskId(createNewTaskId());
        task.setCustomer(customerRepository.getCustomerById(customerId));
        task.setBikeId(bikeId);
        task.setDescription(description);
        task.setIndication(indicationReparation);
        task.setTaskDate(getCurrentDate());
        newTask(task);
        return true;
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        return (dtf.format(localDate));
    }

    private int createNewTaskId() {
        return (getMaxTaskId() + 1);
    }

    public ObservableList getAllCustomerIdsInObservableList() {
        return FXCollections.observableArrayList(getAllCustomerIds());
    }

    public ObservableList getAllBikeIdsInObservableList() {
        return FXCollections.observableArrayList(getAllBikeIds());
    }
}
