package com.BikeStore.Logic.Task;

import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Task.TaskRepository;

import java.util.List;

public class ShowTaskLogic {

    TaskRepository taskRepo = new TaskRepository();

    public List parseTaskList() {
        return taskRepo.getAllTasks();
    }

}
