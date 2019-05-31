package com.BikeStore;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private String databaseName = "java_bikestore";
    private String databaseUsername= "root";
    private String databasePassword = "beech";
    private String databaseHost = "localhost";
    private String databasePort = "3306";


    public Connection ConnectDB() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://"+databaseHost+":"+databasePort+"/"+databaseName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", databaseUsername, databasePassword);
            return conn;

        } catch (Exception e) {
            System.out.println("DB error");
            return null;
        }

    }
}