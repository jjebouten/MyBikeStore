package com.BikeStore.Data.Repository;

import java.util.ArrayList;

public interface QueryBuilderInterface {

    String getAllQuery(String table);

    String getAllByFieldThroughIntQuery(String table, String field, int IntegerValue);

    String getAllByFieldThroughStringQuery(String table, String field, String StringValue);

    int getMax(String table, String field);

    ArrayList<Integer> getIntegerArrayListOfField(String table, String field);
}

