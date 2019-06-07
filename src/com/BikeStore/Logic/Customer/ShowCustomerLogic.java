package com.BikeStore.Logic.Customer;

import com.BikeStore.Data.Repository.Customer.CustomerRepository;

import java.util.List;

public class ShowCustomerLogic extends CustomerRepository {

    protected List parseCustomerList() {
        return getAllCustomers();
    }

}
