package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Modal.MountainBike;
import com.BikeStore.Data.Repository.QueryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MountainBikeRepository extends QueryBuilder {

    static String Table = "Bikes";
    static String BikeType = "MountainBike";

    public ArrayList getAll() {

        String query = getAllByFieldThroughStringQuery("Bikes", "BikeType", BikeType);

        Connection conn = ConnectDB();
        ArrayList<MountainBike> queryResult = new ArrayList<>();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query,// and get a java resultset
            ResultSet result = st.executeQuery(query);

            // iterate through the java resultset
            while (result.next()) {
                MountainBike mountainBike = new MountainBike(result.getInt("BikeId"),
                        result.getString("BikeBrand"),
                        result.getString("BikeType"),
                        result.getDouble("RimSize"),
                        result.getInt("NumberOfGears"),
                        result.getString("DateLastTask"),
                        result.getString("BikeSuspension"));
                queryResult.add(mountainBike);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return queryResult;
    }

    public void createNew(MountainBike mountainBike) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "INSERT INTO " + Table + " (BikeId, BikeType, BikeBrand, RimSize, NumberOfGears, BikeSuspension)"
                    + "VALUES (?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, mountainBike.getBikeId());
            preparedStmt.setString(2, mountainBike.getBikeType());
            preparedStmt.setString(3, mountainBike.getBikeBrand());
            preparedStmt.setDouble(4, mountainBike.getRimSize());
            preparedStmt.setInt(5, mountainBike.getNumberOfGears());
            preparedStmt.setString(6, mountainBike.getSuspension());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
