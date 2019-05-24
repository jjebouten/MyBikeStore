package com.BikeStore.Data.Modal;

public class Task {
    private Integer taskId;
    private Customer customer;
    private Integer bikeId;
    private String indication;
    private String  taskDate;
    private String taskReadyDate;
    private String description;

    public Task(Integer taskId, Customer customer, Integer bikeId, String indication, String taskDate, String taskReadyDate, String description) {
        this.taskId = taskId;
        this.customer = customer;
        this.bikeId = bikeId;
        this.indication = indication;
        this.taskDate = taskDate;
        this.taskReadyDate = taskReadyDate;
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

    public String getTaskReadyDate() {
        return taskReadyDate;
    }

    public void setTaskReadyDate(String taskReadyDate) {
        this.taskReadyDate = taskReadyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
