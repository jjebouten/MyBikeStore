package com.BikeStore.Logic.Customer;

import com.BikeStore.Data.Modal.Customer;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImportCustomerLogic extends CustomerRepository {

    public void importNewCustomers() {
        readCustomersFromCSV("Resources/Customers.csv");
    }

    private void readCustomersFromCSV(String fileName) {
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                createCustomer(attributes);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void createCustomer(String[] metadata) {
        int customerId = getMax("CustomerId", "Customers") + 1;
        String firstName = metadata[0];
        String lastName = metadata[1];
        String address = metadata[2];
        String city = metadata[3];
        String email = metadata[4];
        Customer customer = new Customer(customerId, firstName, lastName, address, city, email);
        createNew(customer);
    }

}