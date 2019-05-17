package com.BikeStore;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection ConnectDB() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_bikestore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "beech");
            return conn;

        } catch (Exception e) {
            System.out.println("DB error");
            return null;
        }

    }
}