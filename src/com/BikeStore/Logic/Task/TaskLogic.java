package com.BikeStore.Logic.Task;

import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Task.TaskRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskLogic {
    private Task task = new Task(null, null, null, "", "", "", "");
    private TaskRepository taskRepository = new TaskRepository();
    private CustomerRepository customerRepository = new CustomerRepository();
    private BikeDefaultRepository bikeRepository = new BikeDefaultRepository();

    private final String indicationReparation = "R";
    private final String indicationDelivery = "A";
    private final String descriptionDelivery = "Afleverbeurt";

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        return (dtf.format(localDate));
    }

    public List parseTaskList() {
        return taskRepository.getAll();
    }

    public void setDateReady(Integer bikeId, Integer taskId) {
        setDateLastTaskOnBike(bikeId, getCurrentDate());
        setDateLastTaskOnTask(taskId, getCurrentDate());
    }

    private void setDateLastTaskOnBike(Integer bikeId, String currentDate) {
        bikeRepository.setDateLastTask(bikeId, currentDate);
    }

    private void setDateLastTaskOnTask(Integer taskId, String currentDate) {
        taskRepository.setTaskReadyDate(taskId, currentDate);
    }

    public boolean createNewReparationTask(Integer customerId, Integer bikeId, String description) {
        if (customerId != null && bikeId != null) {
            return newTaskDefault(customerId, bikeId, description, indicationReparation);
        }
        return false;
    }

    public boolean createNewDeliveryTask(Integer customerId, Integer bikeId) {
        if (customerId != null && bikeId != null) {
            return newTaskDefault(customerId, bikeId, descriptionDelivery, indicationDelivery);
        }
        return false;
    }

    private boolean newTaskDefault(Integer customerId, Integer bikeId, String description, String indicationReparation) {
        task.setTaskId(createNewTaskId());
        task.setCustomer(customerRepository.getCustomerById(customerId));
        task.setBike(bikeRepository.getById(bikeId));
        task.setDescription(description);
        task.setIndication(indicationReparation);
        task.setTaskDate(getCurrentDate());
        taskRepository.createNew(task);
        return true;
    }

    private int createNewTaskId() {
        return (taskRepository.getMax("TaskId", "Tasks") + 1);
    }

    public ObservableList getAllCustomerIdsInObservableList() {
        return FXCollections.observableArrayList(taskRepository.getIntegerArrayListOfField("Customers", "CustomerId"));
    }

    public ObservableList getAllBikeIdsInObservableList() {
        return FXCollections.observableArrayList(taskRepository.getIntegerArrayListOfField("Bikes", "BikeId"));
    }


    public void exportAllTasks(String sortingField) {
        ArrayList<Task> taskList = taskRepository.getAll();
        File csvFile = new File("TaskExport.csv");

        switch(sortingField) {
            case "BikeId":
                Collections.sort(taskList, Comparator.comparingInt(p -> p.getBike().getBikeId()));
                break;
            case "CustomerId":
                Collections.sort(taskList, Comparator.comparingInt(p -> p.getCustomer().getCustomerId()));
                break;
            case "Indication":
                Collections.sort(taskList, Comparator.comparing(Task::getIndication));
                break;
            case "TaskDate":
                Collections.sort(taskList, Comparator.comparing(Task::getTaskDate));
                break;
            default:
                Collections.sort(taskList, Comparator.comparingInt(Task::getTaskId));
        }
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))){
            csvWriter.print("TaskId,TaskDate,TaskDateReady,TaskIndication,TaskDescription,BikeId,BikeBrand,BikeType,BikeDateLastTask,CustomerId,FirstName,Lastname,Address,City,Email"+"\n");
            for(Task task : taskList){
                csvWriter.print(task.getTaskId()+",");
                csvWriter.print(task.getTaskDate()+",");
                csvWriter.print(task.getTaskReadyDate()+",");
                csvWriter.print(task.getIndication()+",");
                csvWriter.print(task.getDescription()+",");
                csvWriter.print(task.getBike().getBikeId()+",");
                csvWriter.print(task.getBike().getBikeBrand()+",");
                csvWriter.print(task.getBike().getBikeType()+",");
                csvWriter.print(task.getBike().getDateLastTask()+",");
                csvWriter.print(task.getCustomer().getCustomerId()+",");
                csvWriter.print(task.getCustomer().getFirstName()+",");
                csvWriter.print(task.getCustomer().getLastName()+",");
                csvWriter.print(task.getCustomer().getAddress()+",");
                csvWriter.print(task.getCustomer().getCity()+",");
                csvWriter.print(task.getCustomer().getEmail()+"\n");
            }
        } catch (IOException e) {
            //Handle exception
            e.printStackTrace();
        }
    }

}