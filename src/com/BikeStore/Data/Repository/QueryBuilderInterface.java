package com.BikeStore.Data.Repository;

import java.util.ArrayList;

public interface QueryBuilderInterface {

    String getAll(String table);

    String getAllByFieldThroughInt(String table, String field, int IntegerValue);

    String getAllByFieldThroughString(String table, String field, String StringValue);

    int getMax(String table, String field);

    ArrayList<Integer> getIntegerArrayListOfField(String table, String field);
}

