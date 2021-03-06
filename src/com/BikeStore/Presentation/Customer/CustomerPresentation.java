package com.BikeStore.Presentation.Customer;

import com.BikeStore.Data.Modal.Customer;
import com.BikeStore.Logic.Customer.CustomerLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;

public class CustomerPresentation implements Initializable {

    CustomerLogic customerLogic = new CustomerLogic();

    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, Integer> customerId;
    @FXML
    private TableColumn<Customer, String> firstName;
    @FXML
    private TableColumn<Customer, String> lastName;
    @FXML
    private TableColumn<Customer, String> address;
    @FXML
    private TableColumn<Customer, String> city;
    @FXML
    private TableColumn<Customer, String> email;

    private void initializeCustomerFields() {
        customerId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerId"));
        firstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        city.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
        email.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCustomerFields();
        if (customerLogic.parseCustomerList().size() > 0) {
            tableView.getItems().setAll(customerLogic.parseCustomerList());
        } else {
            alertError("Error 1558345464", "Something went wrong, Could not fetch results");
        }
    }

}
