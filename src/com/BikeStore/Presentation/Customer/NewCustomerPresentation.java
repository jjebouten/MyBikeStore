package com.BikeStore.Presentation.Customer;

import com.BikeStore.Logic.Customer.CustomerLogic;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;
import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;
import static com.FieldValidator.FieldValidator.isNullOrEmptyString;
import static com.FieldValidator.FieldValidator.isValidEmailAddress;

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

        if (validateCustomer(firstName, lastName, address, city, email)) {
            createNewCustomer(firstName, lastName, address, city, email);
            alertSucces("Succes", "Customer succesfully created");
            txtFirstname.setText("");
            txtLastname.setText("");
            txtAddress.setText("");
            txtCity.setText("");
            txtEmail.setText("");
        }

    }

    private boolean validateCustomer(String firstName, String lastName, String address, String city, String email) {
        if (isNullOrEmptyString(firstName, lastName, address, city)) {
            alertError("Error 1557489176", "Invalid input all fields are required");
            return false;
        }

        if (!isValidEmailAddress(email)) {
            alertError("Error 1557489696", "Invalid email");
            return false;
        }
        return true;
    }

}
