package com.BikeStore.Data.Modal;

import java.util.ArrayList;

public class Company {
    private Integer companyId;
    private String chamberOfCommerce;
    private String ibanNumber;
    private ArrayList<Task> listOfTasks;

    public Company(ArrayList<Task> listOfTasks) {
        this.companyId = 1;
        this.chamberOfCommerce = "12345678";
        this.ibanNumber = "NL91 ABNA 0417 1643 00";
        this.listOfTasks = listOfTasks;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getChamberOfCommerce() {
        return chamberOfCommerce;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(ArrayList<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }
}
