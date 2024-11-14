package com.pluralsight.FoodClasses;

import com.pluralsight.enums.Bread;
import com.pluralsight.enums.Cheeses;
import com.pluralsight.enums.Meat;
import com.pluralsight.enums.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void getCost() {
        Sandwich sandwich = new Sandwich(Size.Medium, Bread.white, true);
        sandwich.addMeat(Meat.ham);
        sandwich.addCheese(Cheeses.cheddar);
        double expected = 10.5;
        assertEquals(expected, sandwich.getCost());
    }

    @Test
    void getBreadCost() {
        Sandwich sandwich = new Sandwich(Size.Medium, Bread.white, true);
        double expected = 7;
        assertEquals(expected, sandwich.getBreadCost());

        sandwich.setSize(Size.Small);
        expected = 5.5;
        assertEquals(expected, sandwich.getBreadCost());

        sandwich.setSize(Size.Large);
        expected = 8.5;
        assertEquals(expected, sandwich.getBreadCost());
    }

    @Test
    void getMeatCost() {
        Sandwich sandwich = new Sandwich(Size.Medium, Bread.white, true);
        sandwich.addMeat(Meat.ham);
        sandwich.addMeat(Meat.bacon);
        sandwich.addMeat(Meat.roastBeef);
        sandwich.setHasExtraMeat(true);
        double expected = 7;
        assertEquals(expected, sandwich.getMeatCost());

        sandwich.setSize(Size.Small);
        expected = 3.5;
        assertEquals(expected, sandwich.getMeatCost());

        sandwich.setSize(Size.Large);
        expected = 10.5;
        assertEquals(expected, sandwich.getMeatCost());
    }

    @Test
    void getCheeseCost() {
        Sandwich sandwich = new Sandwich(Size.Medium, Bread.white, true);
        sandwich.addCheese(Cheeses.cheddar);
        sandwich.addCheese(Cheeses.american);
        sandwich.setHasExtraCheese(true);
        double expected = 3.6;
        assertEquals(expected, sandwich.getCheeseCost());

        sandwich.setSize(Size.Small);
        expected = 1.8;
        assertEquals(expected, sandwich.getCheeseCost());

        sandwich.setSize(Size.Large);
        expected = 5.4;
        assertEquals(expected, sandwich.getCheeseCost());
    }
}