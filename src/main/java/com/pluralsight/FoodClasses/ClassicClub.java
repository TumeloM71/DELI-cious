package com.pluralsight.FoodClasses;

import com.pluralsight.enums.*;

public class ClassicClub extends Sandwich{

    public ClassicClub() {

        super(Size.Medium, Bread.white, false);
        this.addMeat(Meat.ham);
        this.addMeat(Meat.bacon);
        this.addMeat(Meat.roastBeef);
        this.addCheese(Cheeses.american);
        this.addCheese(Cheeses.swiss);
        this.addRegularToppings(RegularToppings.lettuce);
        this.addRegularToppings(RegularToppings.pickles);
        this.addRegularToppings(RegularToppings.tomatoes);
        this.addSauce(Sauces.mayo);
        this.addSide(Sides.au_jus);
    }

    @Override
    public String toString() {
        return "Classic Club Sandwich{"+
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
