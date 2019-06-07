package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Modal.BikeDefault;
import com.BikeStore.Data.Repository.QueryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BikeDefaultRepository extends QueryBuilder {

    static String Table = "Bikes";

    public boolean CheckIfIdExistsInDatabase(int bikeId) {

        //Always exists so it does nothing
        boolean exists = true;

        String query = getAllByFieldThroughInt("Bikes", "bikeId", bikeId);
        Connection conn = ConnectDB();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = st.executeQuery(query);

            if (!result.isBeforeFirst()) {
                exists = false;
            }

            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return exists;
    }

    public void setDateLastTask(Integer bikeId, String currentDate) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "UPDATE " + Table + " SET DateLastTask = ? WHERE BikeId = ?";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString   (1, currentDate);
            preparedStmt.setInt(2, bikeId);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public BikeDefault getBikeById(int bikeId) {

            String query = getAllByFieldThroughInt(Table, "bikeId", bikeId);
            BikeDefault bike = new BikeDefault(bikeId, "", "", 0.0, 0, "") {
            };
            Connection conn = ConnectDB();
            try {
                // create the java statement
                Statement st = conn.createStatement();

                // execute the query, and get a java resultset
                ResultSet result = st.executeQuery(query);

                // iterate through the java resultset
                while (result.next()) {
                    bike.setBikeBrand(result.getString("BikeBrand"));
                    bike.setBikeType(result.getString("BikeType"));
                    bike.setRimSize(result.getDouble("RimSize"));
                    bike.setNumberOfGears(result.getInt("NumberOfGears"));
                    bike.setDateLastTask(result.getString("DateLastTask"));
                }
                st.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
            return bike;
    }
}
