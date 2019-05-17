package com.BikeStore.Data.Modal;

public class Task {
    private int taskId;
    private Customer customer;
    private BikeDefault bike;
    private int indication;
    private int taskDate;
    private int taskDateReady;
    private String Description;

    public Task(int taskId, Customer customer, BikeDefault bike, int indication, int taskDate, int taskDateReady, String description) {
        this.taskId = taskId;
        this.customer = customer;
        this.bike = bike;
        this.indication = indication;
        this.taskDate = taskDate;
        this.taskDateReady = taskDateReady;
        Description = description;
    }
}
