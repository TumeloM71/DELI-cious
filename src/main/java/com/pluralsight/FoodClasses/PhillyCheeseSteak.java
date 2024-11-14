package com.pluralsight.FoodClasses;

import com.pluralsight.enums.*;

public class PhillyCheeseSteak extends Sandwich{
    public PhillyCheeseSteak() {
        super(Size.Medium, Bread.white, true);
        this.addMeat(Meat.steak);
        this.addCheese(Cheeses.american);
        this.addRegularToppings(RegularToppings.peppers);
        this.addSauce(Sauces.mayo);
    }

    @Override
    public String toString() {
        return "Philly Cheese Steak Sandwich{"+
                "size:" + getSizeInInches() +" inches" +
                ", bread:" + this.getBread() +
                ", toasted:" + this.isToasted() +
                ", extraMeat:" + this.hasExtraMeat() +
                ", extraCheese:" + this.hasExtraCheese() + "\n" +
                ", regularToppings:" + this.getRegularToppings() + "\n" +
                ", meat:" + this.getMeats() + "\n" +
                ", cheese:" + this.getCheeses() + "\n" +
                ", sauces:" + this.getSauces() + "\n" +
                ", sides:" + this.getSides() + "\n" +
                ", cost: $" +  String.format("%.2f",getCost())
                + '}';
    }
}
