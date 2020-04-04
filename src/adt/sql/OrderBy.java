package adt.sql;

import javafx.util.Pair;

import java.util.ArrayList;

public class OrderBy {

    private ArrayList<Pair<String, Ordering>> orderBys;

    public OrderBy() {
        orderBys = new ArrayList<>();
    }

    public void add(String field, Ordering ordering) {
        orderBys.add(new Pair<>(field, ordering));
    }

    public void add(String field) {
        orderBys.add(new Pair<String, Ordering>(field, Ordering.ASC));
    }

    public ArrayList<Pair<String, Ordering>> getPairs() {
        return orderBys;
    }


}
