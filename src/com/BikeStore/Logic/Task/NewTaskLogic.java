package com.BikeStore.Logic.Task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NewTaskLogic extends TaskLogic {

    protected boolean createNewReparationTask(Integer customerId, Integer bikeId, String description) {
        if (customerId != null || bikeId != null) {
            return newTaskDefault(customerId, bikeId, description, indicationReparation);
        }
        return false;
    }

    protected boolean createNewDeliveryTask(Integer customerId, Integer bikeId) {
        if (customerId != null || bikeId != null) {
            return newTaskDefault(customerId, bikeId, descriptionDelivery, indicationDelivery);
        }
        return false;
    }


    private boolean newTaskDefault(Integer customerId, Integer bikeId, String description, String
            indicationReparation) {
        task.setTaskId(createNewTaskId());
        task.setCustomer(customerRepository.getCustomerById(customerId));
        task.setBikeId(bikeId);
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
