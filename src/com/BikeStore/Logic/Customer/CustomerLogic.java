package com.BikeStore.Logic.Customer;

import com.BikeStore.Data.Modal.Customer;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;

import java.util.List;

public class CustomerLogic extends CustomerRepository {

    public void createNewCustomer(String firstName, String lastName, String address, String city, String email) {
        Customer newCustomer = new Customer(createNewCustomerId(), firstName, lastName, address, city, email);
        newCustomer(newCustomer);
    }

    private int createNewCustomerId() {
        return getMaxCustomerId() + 1;
    }


    protected List parseCustomerList() {
        return getAllCustomers();
    }

}
