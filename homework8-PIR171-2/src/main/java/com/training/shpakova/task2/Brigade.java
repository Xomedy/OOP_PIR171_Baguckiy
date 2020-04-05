package com.training.shpakova.task2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Brigade {
    private String name;
    private ArrayList brigade;
    private BigDecimal cost;

    public Brigade(String name) {
        this.name = name;
        brigade = new ArrayList();
        cost = new BigDecimal(0);
    }

    public void setBrigade(Worker[] brigade) {
        this.brigade.addAll(Arrays.asList(brigade));
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public ArrayList getBrigade() {
        return brigade;
    }

    public BigDecimal getCost() {
        return cost;
    }

}
