package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Repository.QueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class BikeDefaultRepository extends QueryBuilder {


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


}
