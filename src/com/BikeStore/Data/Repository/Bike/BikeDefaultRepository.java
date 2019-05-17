package com.BikeStore.Data.Repository.Bike;

import com.BikeStore.Data.Repository.QueryBuilder;

public class BikeDefaultRepository extends QueryBuilder {

//    public ArrayList getAllBikeDefaults() {
//        String query = "SELECT * FROM BikeDefaults";
//    }
//
//    public ArrayList getBikeDefaultById(int bikeId) {
//        String query = "SELECT * FROM `BikeDefaults` WHERE `BikeDefaultId`='" + bikeId + "'";
//    }
//
//    public ArrayList getBikeDefaultsByType(int bikeType) {
//        ArrayList<BikeDefault> BikeDefaultList = new ArrayList<>();
//        String query = "SELECT * FROM `BikeDefaults` WHERE `BikeDefaultType`='" + bikeType + "'";
//    }
//
//    public ArrayList getAdditionalBikeDefaultInfoForType(String table, int bikeId) {
//        ArrayList<BikeDefault> BikeDefaultList = new ArrayList<>();
//        String query = "SELECT * FROM '" + table + "' WHERE `BikeDefaultId`='" + bikeId + "'";
//    }

//    public ArrayList getAllBikeDefaults() {
//
//        String query = getAll("Bikes");
//
//        Connection conn = ConnectDB();
//        ArrayList<BikeDefault> queryResult = new ArrayList<>();
//        try {
//            // create the java statement
//            Statement st = conn.createStatement();
//
//            // execute the query, and get a java resultset
//            ResultSet result = st.executeQuery(query);
//
//            // iterate through the java resultset
//            while (result.next()) {
//                BikeDefault bikeDefault  = new BikeDefault(result.getInt("bikeId"),
//                        result.getString("bikeBrand"),
//                        result.getInt("bikeType"),
//                        result.getDouble("rimSize"),
//                        result.getInt("numberOfGears"),
//                        result.getDate("dateLastTask"));
//                queryResult.add(bikeDefault);
//            }
//            st.close();
//        } catch (Exception e) {
//            System.err.println("Got an exception!");
//            System.err.println(e.getMessage());
//        }
//        return queryResult;
//    }

}
