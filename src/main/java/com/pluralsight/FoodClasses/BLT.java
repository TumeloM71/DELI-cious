package com.pluralsight.FoodClasses;

import com.pluralsight.enums.*;

public class BLT extends Sandwich{

    public BLT() {
        super(Size.Medium, Bread.white, true);
        this.addMeat(Meat.bacon);
        this.addCheese(Cheeses.cheddar);
        this.addRegularToppings(RegularToppings.lettuce);
        this.addRegularToppings(RegularToppings.tomatoes);
        this.addSauce(Sauces.ranch);
    }

    @Override
    public String toString() {
        return "BLT Sandwich{"+
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
