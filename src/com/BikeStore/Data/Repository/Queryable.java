package com.BikeStore.Data.Repository;

import java.util.ArrayList;

public interface Queryable<V> {

    ArrayList<V> getAll();

    void createNew(V parameter);

}
