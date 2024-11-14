package com.pluralsight.HelperClasses;

import com.pluralsight.FoodClasses.BLT;
import com.pluralsight.FoodClasses.PhillyCheeseSteak;
import com.pluralsight.FoodClasses.Sandwich;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @org.junit.jupiter.api.Test
    void getTotalCost() {
        Sandwich blt = new BLT();
        Sandwich phillyCheeseSteak = new PhillyCheeseSteak();

        Order order= new Order();
        order.addItem(blt); order.addItem(phillyCheeseSteak);

        double expected = 10.5 + 10.5;
        assertEquals( expected, order.getTotalCost());
    }
}