package com.BikeStore.Data.Repository;

import com.BikeStore.Database;

import java.sql.Connection;
import java.sql.ResultSet;

public class QueryBuilder extends Database implements QueryBuilderInterface {

    public String getAll(String table) {
        return "SELECT * FROM " + table;
    }

    public String getAllByFieldThroughInt(String table, String field, int IntegerValue) {
        return "SELECT * FROM " + table + " WHERE " + field + "=" + IntegerValue;
    }

    public String getAllByFieldThroughString(String table, String field, String StringValue) {
        return "SELECT * FROM " + table + " WHERE " + field + "='" + StringValue + "'";
    }

    public int getMax(String table, String field) {

        String query = "SELECT MAX(" + field + ") FROM " + table;

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

}
