package com.pluralsight.FoodClasses;

import com.pluralsight.Product;
import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.Size;

import java.util.Objects;

public class Drink extends Product {

    private DrinkFlavor flavor;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink drink)) return false;
        if (!super.equals(o)) return false;
        return size == drink.size && getFlavor() == drink.getFlavor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFlavor());
    }

    @Override
    public String toString() {
        return "Drink{Flavor: " + flavor +
                ", Size: " + size +
                ", Cost: $" + String.format("%.2f",getCost())+"}";
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(DrinkFlavor flavor) {
        this.flavor = flavor;
    }
}
