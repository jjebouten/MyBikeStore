package com.BikeStore.Presentation.ActionComponents;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuPresentation {

    @FXML
    public AnchorPane content;

    private void setNewContent(Pane newContent) {
        try {
            content.getChildren().clear();
            content.getChildren().add(newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewAllCityBikes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/allCityBikes.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewAllElectricBikes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/allElectricBikes.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewAllMountainBikes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/allMountainBikes.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewAllCustomers() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/allCustomers.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewAllTasks() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/allTasks.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewNewBike() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newBike.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewNewCustomer() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newCustomer.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    @FXML
    private void viewNewTask() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newTasks.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    public void viewNewCityBikes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newCityBike.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    public void viewNewMountainBikes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newMountainBike.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }

    public void viewNewElectricBikes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newElectricBike.fxml"));
        Pane newContent = fxmlLoader.load();
        setNewContent(newContent);
    }
}
