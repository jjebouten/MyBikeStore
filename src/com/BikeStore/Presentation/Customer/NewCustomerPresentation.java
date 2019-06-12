package com.BikeStore.Presentation.Customer;

import com.BikeStore.Logic.Customer.CustomerLogic;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class NewCustomerPresentation extends CustomerLogic {

    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtEmail;

    //Method use the handle the different buttons' action.
    @FXML
    private void registerCustomer() {

        String firstName = txtFirstname.getText();
        String lastName = txtLastname.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String email = txtEmail.getText();

        if (createNewCustomer(firstName, lastName, address, city, email)){
           alertSucces("Succes", "Customer succesfully created");
           txtFirstname.setText("");
           txtLastname.setText("");
           txtAddress.setText("");
           txtCity.setText("");
           txtEmail.setText("");
        }

    }

}
