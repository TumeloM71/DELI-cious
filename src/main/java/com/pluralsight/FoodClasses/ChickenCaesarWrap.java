package com.pluralsight.FoodClasses;

import com.pluralsight.enums.*;

import java.util.Arrays;

public class ChickenCaesarWrap extends Sandwich{

    public ChickenCaesarWrap() {
        super(Size.Medium, Bread.wrap, false);
        this.addMeat(Meat.chicken);
        this.addCheese(Cheeses.provolone);
        this.addRegularToppings(RegularToppings.lettuce);
        this.addRegularToppings(RegularToppings.tomatoes);
        this.addSauce(Sauces.ranch);
    }

    @Override
    public String toString() {
        return "Chicken Caesar Wrap Sandwich{"+
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
