package com.pluralsight.enums;


public enum BreadCosts {

    small(5.5),
    medium(7.0),
    large(8.5);

    private final double cost;

    private BreadCosts(double cost){
        this.cost = cost;
    }
}
