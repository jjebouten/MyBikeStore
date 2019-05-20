package com.BikeStore.Data.Repository.Customer;

import com.BikeStore.Data.Modal.Customer;
import com.BikeStore.Data.Repository.QueryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerRepository extends QueryBuilder {

    static String Table = "Customers";

    public ArrayList getAllCustomers() {

        String query = getAll(Table);

        Connection conn = ConnectDB();
        ArrayList<Customer> queryResult = new ArrayList<>();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = st.executeQuery(query);

            // iterate through the java resultset
            while (result.next()) {
                Customer customer = new Customer(result.getInt("CustomerId"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Address"),
                        result.getString("City"),
                        result.getString("Email"));
                queryResult.add(customer);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return queryResult;
    }

    public void newCustomer(Customer customer) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "INSERT INTO " + Table + " (CustomerId, FirstName, LastName, Address, City, Email)"
                    + "VALUES (?, ?, ?, ?, ?,?)";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, customer.getCustomerId());
            preparedStmt.setString(2, customer.getFirstName());
            preparedStmt.setString(3, customer.getLastName());
            preparedStmt.setString(4, customer.getAddress());
            preparedStmt.setString(5, customer.getCity());
            preparedStmt.setString(6, customer.getEmail());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public Customer getCustomerById(int customerId) {

        String query = getAllByFieldThroughInt(Table, "CustomerId", customerId);
        Customer customer = new Customer(customerId, "", "", "", "", "");
        Connection conn = ConnectDB();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = st.executeQuery(query);

            // iterate through the java resultset
            while (result.next()) {
                customer.setFirstName(result.getString("FirstName"));
                customer.setLastName(result.getString("LastName"));
                customer.setAddress(result.getString("Address"));
                customer.setCity(result.getString("City"));
                customer.setEmail(result.getString("Email"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return customer;
    }

    public int getMaxCustomerId() {
        return getMax(Table, "customerId");
    }

}
