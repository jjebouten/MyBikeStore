package com.BikeStore.Logic.Customer;

import com.BikeStore.Data.Modal.Customer;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;
import static com.FieldValidator.FieldValidator.isNullOrEmptyString;
import static com.FieldValidator.FieldValidator.isValidEmailAddress;

public class NewCustomerLogic {

    private CustomerRepository CustomerRepo = new CustomerRepository();

    public boolean createNewCustomer(String firstName, String lastName, String address, String city, String email) {

        if (validateCustomer(firstName, lastName, address, city, email)) {
            Customer newCustomer = new Customer(createNewCustomerId(), firstName, lastName, address, city, email);
            CustomerRepo.newCustomer(newCustomer);
            return true;
        } else
            return false;
    }

    private int createNewCustomerId() {
        return CustomerRepo.getMaxCustomerId() + 1;
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
