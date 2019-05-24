package com.BikeStore.Logic.Task;

import java.util.List;

public class ShowTaskLogic extends TaskLogic {


    public List parseTaskList() {
        return taskRepository.getAllTasks();
    }

    public void setTaskReadyDate(Integer bikeId, Integer taskId) {
        setTaskReadyDate(bikeId, getCurrentDate());
        setBikeDateLastTask(taskId, getCurrentDate());
    }

    public void setTaskReadyDate(Integer bikeId, String currentDate) {
        bikeRepository.setDateLastTask(bikeId, currentDate);
    }

    public void setBikeDateLastTask(Integer taskId, String currentDate) {
        taskRepository.setTaskReadyDate(taskId, currentDate);
    }
}
