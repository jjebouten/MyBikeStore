package com.BikeStore.Presentation.Customer;

import com.BikeStore.Logic.Customer.CustomerLogic;
import javafx.event.ActionEvent;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class ImportCustomerPresentation {

    CustomerLogic customerLogic = new CustomerLogic();

    public void importCustomers(ActionEvent actionEvent) {
        customerLogic.importNewCustomers();
        alertSucces("Customers added", "Customers are added into the database");
    }
}
