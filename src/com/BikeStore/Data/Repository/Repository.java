package com.BikeStore.Data.Repository;

import com.BikeStore.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repository extends Database {

    public int getMax(String uidFieldName, String table) {
        String query = "SELECT MAX(" + uidFieldName + ") FROM " + table;

        Connection conn = ConnectDB();
        int max = 0;

        try {
            java.sql.Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return max;
    }

    public ArrayList<Integer> getIntegerArrayListOfField(String table, String field) {
        String query = "SELECT (" + field + ") FROM " + table;
        Connection conn = ConnectDB();

        ArrayList<Integer> queryResult = new ArrayList<>();

        try {
            java.sql.Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                queryResult.add(result.getInt(field));
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return queryResult;
    }

}
