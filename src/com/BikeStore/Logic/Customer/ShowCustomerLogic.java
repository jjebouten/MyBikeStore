package com.BikeStore.Logic.Customer;

import com.BikeStore.Data.Repository.Customer.CustomerRepository;

import java.util.List;

public class ShowCustomerLogic {

    CustomerRepository customerRepository = new CustomerRepository();

    public List parseCustomerList() {
        return customerRepository.getAllCustomers();
    }

}
