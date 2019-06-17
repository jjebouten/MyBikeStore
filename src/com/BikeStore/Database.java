package com.BikeStore;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.BikeStore.Presentation.ActionComponents.AlertPresentation.alertError;

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
            alertError("Something went wrong", "Database Connection failed");
            return null;
        }

    }
}