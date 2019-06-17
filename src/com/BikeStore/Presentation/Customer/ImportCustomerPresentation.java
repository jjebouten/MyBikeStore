package com.BikeStore.Presentation.Customer;

import com.BikeStore.Logic.Customer.ImportCustomerLogic;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertSucces;

public class ImportCustomerPresentation extends ImportCustomerLogic {

    public void importCustomers(ActionEvent actionEvent) {
        importNewCustomers();
        alertSucces("Customers added", "Customers are added into the database");
    }
}
