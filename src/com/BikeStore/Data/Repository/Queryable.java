package com.BikeStore.Data.Repository;

import java.util.ArrayList;
import java.util.List;

public interface Queryable<V> {

    ArrayList<V> getAll();

    void createNew(V parameter);

}
