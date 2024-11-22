package com.pluralsight.enums;


import com.pluralsight.FoodClasses.*;

public enum SignatureSandwichMenu {

    blt(new BLT()),
    chickenCaesarWrap(new ChickenCaesarWrap()),
    classicClub(new ClassicClub()),
    hamAndCheese(new HamAndCheese()),
    phillyCheeseSteak(new PhillyCheeseSteak());

    private final Sandwich sandwich;

    public Sandwich getSandwich() {
        return sandwich;
    }

    private SignatureSandwichMenu(Sandwich sandwich){
        this.sandwich = sandwich;
    }
}
