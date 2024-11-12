package com.pluralsight;

import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.Size;

public class Drink extends Product{

    DrinkFlavor flavor;

    public Drink(Size size, DrinkFlavor flavor) {
        super(size);
        this.flavor = flavor;
    }

    @Override
    public double getCost() {
        double cost = 0;
        switch (this.size){
            case Small -> cost = 2.0;
            case Medium -> cost = 2.5;
            case Large -> cost = 3.0;
        }

        return cost;
    }

    @Override
    public String toString() {
        return "Drink{" + flavor +
                ", " + size +
                ", $" + this.getCost()+"}";
    }
}
