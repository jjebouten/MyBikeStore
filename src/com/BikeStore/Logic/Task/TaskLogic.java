package com.BikeStore.Logic.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Task.TaskRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TaskLogic extends TaskRepository {
    Task task = new Task(null, null, null, "", "", "", "");
    CustomerRepository customerRepository = new CustomerRepository();
    BikeDefaultRepository bikeRepository = new BikeDefaultRepository();
    TaskRepository taskRepository = new TaskRepository();

    static String indicationReparation = "R";
    static String indicationDelivery = "A";
    static String descriptionDelivery = "Afleverbeurt";

    String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        return (dtf.format(localDate));
    }

}
