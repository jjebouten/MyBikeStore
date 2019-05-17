package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Modal.ElectricBike;
import com.BikeStore.Data.Repository.QueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ElectricBikeRepository extends QueryBuilder {

    static String fieldValue = "ElectricBike";

    public ArrayList getAllElectricBikes() {

        String query = getAllByFieldThroughString("Bikes", "BikeType", fieldValue);

        Connection conn = ConnectDB();
        ArrayList<ElectricBike> queryResult = new ArrayList<>();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = st.executeQuery(query);

            // iterate through the java resultset
            while (result.next()) {
                ElectricBike electricBike = new ElectricBike(result.getInt("BikeId"),
                        result.getString("BikeBrand"),
                        result.getString("BikeType"),
                        result.getDouble("RimSize"),
                        result.getInt("NumberOfGears"),
                        result.getDate("DateLastTask"),
                        result.getDouble("BikePower"));
                queryResult.add(electricBike);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return queryResult;
    }

}
