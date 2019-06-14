package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Modal.ElectricBike;
import com.BikeStore.Data.Modal.MountainBike;
import com.BikeStore.Data.Repository.Queryable;
import com.BikeStore.Data.Repository.Repository;
import com.BikeStore.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ElectricBikeRepository extends Repository implements Queryable<ElectricBike> {

    static String Table = "Bikes";
    static String BikeTypeField = "BikeType";
    static String BikeType = "ElectricBike";

    @Override
    public ArrayList<ElectricBike> getAll() {
        String query = "SELECT * FROM " + Table + " WHERE " + BikeTypeField + "='" + BikeType + "'";

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
                        result.getString("DateLastTask"),
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

    @Override
    public void createNew(ElectricBike electricBike) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "INSERT INTO " + Table + " (BikeId, BikeType, BikeBrand, RimSize, NumberOfGears, BikePower)"
                    + "VALUES (?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, electricBike.getBikeId());
            preparedStmt.setString(2, electricBike.getBikeType());
            preparedStmt.setString(3, electricBike.getBikeBrand());
            preparedStmt.setDouble(4, electricBike.getRimSize());
            preparedStmt.setInt(5, electricBike.getNumberOfGears());
            preparedStmt.setDouble(6, electricBike.getPower());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
