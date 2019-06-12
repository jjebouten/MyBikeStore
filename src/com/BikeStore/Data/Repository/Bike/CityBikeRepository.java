package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Modal.BikeDefault;
import com.BikeStore.Data.Modal.CityBike;
import com.BikeStore.Data.Repository.QueryBuilder;

import java.sql.*;
import java.util.ArrayList;

public class CityBikeRepository extends QueryBuilder {

    static String Table = "Bikes";
    static String BikeType = "CityBike";

    public ArrayList getAll() {

        String query = getAllByFieldThroughStringQuery("Bikes", "BikeType", BikeType);

        Connection conn = ConnectDB();
        ArrayList<CityBike> queryResult = new ArrayList<>();
        try {
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = st.executeQuery(query);

            // iterate through the java resultset
            while (result.next()) {
                CityBike cityBike = new CityBike(result.getInt("BikeId"),
                        result.getString("BikeBrand"),
                        result.getString("BikeType"),
                        result.getDouble("RimSize"),
                        result.getInt("NumberOfGears"),
                        result.getString("DateLastTask"),
                        result.getString("BikeBag"));
                queryResult.add(cityBike);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return queryResult;
    }

    public void createNew(CityBike cityBike) {
        try {
            // create a mysql database connection
            Connection conn = ConnectDB();
            // create a sql date object so we can use it in our INSERT statement

            // the mysql insert statement
            String query = "INSERT INTO " + Table + " (BikeId, BikeType, BikeBrand, RimSize, NumberOfGears, BikeBag)"
                    + "VALUES (?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            assert conn != null;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, cityBike.getBikeId());
            preparedStmt.setString(2, cityBike.getBikeType());
            preparedStmt.setString(3, cityBike.getBikeBrand());
            preparedStmt.setDouble(4, cityBike.getRimSize());
            preparedStmt.setInt(5, cityBike.getNumberOfGears());
            preparedStmt.setString(6, cityBike.getBikeBags());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
