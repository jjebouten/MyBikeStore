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
        return getAll();
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
        task.setBike(bikeRepository.getById(bikeId));
        task.setDescription(description);
        task.setIndication(indicationReparation);
        task.setTaskDate(getCurrentDate());
        createNew(task);
        return true;
    }

    private int createNewTaskId() {
        return (getMax("TaskId", "Tasks") + 1);
    }

    protected ObservableList getAllCustomerIdsInObservableList() {
        return FXCollections.observableArrayList(getIntegerArrayListOfField("Customers", "CustomerId"));
    }

    protected ObservableList getAllBikeIdsInObservableList() {
        return FXCollections.observableArrayList(getIntegerArrayListOfField("Bikes", "BikeId"));
    }


    protected void exportAllTasks(String sortingField) {
        ArrayList<Task> taskList = getAll();
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