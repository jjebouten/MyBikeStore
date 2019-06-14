package com.BikeStore.Data.Repository.Task;

import com.BikeStore.Data.Modal.BikeDefault;
import com.BikeStore.Data.Modal.Customer;
import com.BikeStore.Data.Modal.Task;
import com.BikeStore.Data.Repository.Bike.BikeDefaultRepository;
import com.BikeStore.Data.Repository.Customer.CustomerRepository;
import com.BikeStore.Data.Repository.Queryable;
import com.BikeStore.Data.Repository.Repository;
import com.BikeStore.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TaskRepository extends Repository implements Queryable<Task> {

    private static String Table = "Tasks";
    private static String UidFieldName = "TaskId";
    CustomerRepository customerRepository = new CustomerRepository();
    BikeDefaultRepository bikeDefaultRepository = new BikeDefaultRepository();

    @Override
    public ArrayList<Task> getAll() {
        String query = "SELECT * FROM " + Table;

        Connection conn = ConnectDB();
        ArrayList<Task> queryResult = new ArrayList<>();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = st.executeQuery(query);

            // iterate through the java resultset
            while (result.next()) {
                Customer customer = customerRepository.getCustomerById(result.getInt("CustomerId"));
                BikeDefault bike = bikeDefaultRepository.getById(result.getInt("BikeId"));

                Task task = new Task(result.getInt("TaskId"),
                        customer,
                        bike,
                        result.getString("Indication"),
                        result.getString("TaskDate"),
                        result.getString("TaskReadyDate"),
                        result.getString("Description"));
                queryResult.add(task);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return queryResult;
    }

    @Override
    public void createNew(Task task) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "INSERT INTO " + Table + " (TaskId, CustomerId, BikeId, Indication, TaskDate, Description)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, task.getTaskId());
            preparedStmt.setInt(2, task.getCustomer().getCustomerId());
            preparedStmt.setInt(3, task.getBike().getBikeId());
            preparedStmt.setString(4, task.getIndication());
            preparedStmt.setString(5, task.getTaskDate());
            preparedStmt.setString(6, task.getDescription());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void setTaskReadyDate(Integer taskId, String currentDate) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "UPDATE " + Table + " SET TaskReadyDate = ? WHERE TaskId = ?";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, currentDate);
            preparedStmt.setInt(2, taskId);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
