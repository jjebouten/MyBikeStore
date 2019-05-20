package com.BikeStore.Logic.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Task.TaskRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewTaskReparationLogic extends TaskRepository {

    static String Indication = "R";
    static String Table = "Tasks";

    Task reparationTask = new Task(null, null, null, "", "", "", "");
    CustomerRepository customerRepository = new CustomerRepository();

    public ObservableList getAllCustomerIdsInObservableList() {
        return FXCollections.observableArrayList(getAllCustomerIds());
    }

    public ObservableList getAllBikeIdsInObservableList() {
        return FXCollections.observableArrayList(getAllBikeIds());
    }

    public boolean createNewReparationTask(Integer customerId, Integer bikeId, String description) {
        reparationTask.setTaskId(createNewTaskId());
        reparationTask.setCustomer(customerRepository.getCustomerById(customerId));
        reparationTask.setBikeId(bikeId);
        reparationTask.setDescription(description);
        reparationTask.setIndication(Indication);
        reparationTask.setTaskDate(getCurrentDate());
        newReparationTask(reparationTask);
        return true;
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        return (dtf.format(localDate));
    }

    public int createNewTaskId() {
        return (getMaxTaskId() + 1);
    }
}
