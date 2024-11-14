package com.pluralsight.FoodClasses;

import com.pluralsight.enums.*;

public class HamAndCheese extends Sandwich{
    public HamAndCheese() {
        super(Size.Medium, Bread.white, true);
        this.addMeat(Meat.ham);
        this.addCheese(Cheeses.cheddar);
        this.addRegularToppings(RegularToppings.tomatoes);
    }

    @Override
    public String toString() {
        return "Ham & Cheese Sandwich{"+
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
