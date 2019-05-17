package com.BikeStore.Logic.Customer;

import com.BikeStore.Data.Repository.Customer.CustomerRepository;

import java.util.List;

public class ShowCustomerLogic {

    CustomerRepository customerRepo = new CustomerRepository();

    public List parseCustomerList() {
        return customerRepo.getAllCustomers();
    }

}
