package com.BikeStore.Data.Modal;

public class Task {
    private Integer taskId;
    private Customer customer;
    private Integer bikeId;
    private String indication;
    private String  taskDate;
    private String taskDateReady;
    private String description;

    public Task(Integer taskId, Customer customer, Integer bike, String indication, String taskDate, String taskDateReady, String description) {
        this.taskId = taskId;
        this.customer = customer;
        this.bikeId = bike;
        this.indication = indication;
        this.taskDate = taskDate;
        this.taskDateReady = taskDateReady;
        this.description = description;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskDateReady() {
        return taskDateReady;
    }

    public void setTaskDateReady(String taskDateReady) {
        this.taskDateReady = taskDateReady;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
