package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sandwich extends Product{

    Bread bread;
    boolean isToasted, hasExtraMeat, hasExtraCheese;
    List<RegularToppings> regularToppings;
    List<Meat> meats;
    List<Cheeses> cheeses;
    List<Sauces> sauces;
    List<Sides> sides;


    public Sandwich(Size size, Bread bread, boolean isToasted) {
        super(size);
        this.bread = bread;
        this.isToasted = isToasted;
        regularToppings = new ArrayList<>();
        meats = new ArrayList<>();
        cheeses= new ArrayList<>();
        sauces = new ArrayList<>();
        sides = new ArrayList<>();
        hasExtraMeat = false;
        hasExtraCheese = false;
    }

    public void setHasExtraMeat(boolean hasExtraMeat) {
        this.hasExtraMeat = hasExtraMeat;
    }

    public void setHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void addRegularToppings(RegularToppings t){
        if (!regularToppings.contains(t)) {
            regularToppings.add(t);
            System.out.println("Added successfully");
        }
        else
            System.out.println("Topping was already present");
    }

    public void removeRegularTopping(RegularToppings t){
        if (regularToppings.remove(t))
            System.out.println("Removed successfully");
        else
            System.out.println("Item was not present");
    }

    public void addMeat(Meat meat) {
        if (!meats.contains(meat)){
            meats.add(meat);
            System.out.println("Added successfully");
        }
        else
            System.out.println("Topping was already present");
    }

    public void removeMeat(Meat meat){
        meats.remove(meat);
    }

    public void addCheese (Cheeses cheese){
        if( !cheeses.contains(cheese)){
            cheeses.add(cheese);
            System.out.println("Added successfully");
        }
        else
            System.out.println("Topping was already present");

    }

    public void removeCheese(Cheeses cheese){
        cheeses.remove(cheese);
    }

    public void addSauce(Sauces sauce){
        if (!sauces.contains(sauce)){
            sauces.add(sauce);
            System.out.println("Added successfully");
        }
        else
            System.out.println("Sauce was already present");

    }

    public void removeSauce(Sauces sauce){
        sauces.remove(sauce);
    }

    public void addSide(Sides side){
        if ( !sides.contains(side)){
            sides.add(side);
            System.out.println("Added successfully");
        }
        else
            System.out.println("Side was already present");

    }

    public void removeSide(Sides side){
        sides.remove(side);
    }

    @Override
    public double getCost() {
        return getBreadCost() + getCheeseCost() + getMeatCost();
    }

    public double getBreadCost(){
        double cost = -1;
        switch (this.size){
            case Large -> cost = 8.5;
            case Medium -> cost = 7.0;
            case Small -> cost = 5.5;
        }
        return cost;
    }

    /*Gets the cost of the additional meat toppings taking into account the hasExtraMeat boolean
     */
    public double getMeatCost(){
        double cost = -1;
        double costOfExtraMeat = 0;
        switch (this.size){
            case Large -> {cost = 3.0; costOfExtraMeat = 1.5;}
            case Medium -> {cost = 2.0; costOfExtraMeat = 1.0;}
            case Small -> {cost = 1.0; costOfExtraMeat = 0.5;}
        }

        return hasExtraMeat ? costOfExtraMeat + cost*meats.size() : cost*meats.size() ;
    }

    /*Gets the cost of the additional cheese topping taking into account the hasExtraCheese boolean
     */
    public double getCheeseCost(){
        double cost = -1;
        double costOfExtraCheese = 0;
        switch (this.size){
            case Large -> {cost = 2.25; costOfExtraCheese =0.90;}
            case Medium -> {cost = 1.5; costOfExtraCheese = 0.60;}
            case Small -> {cost = 0.75; costOfExtraCheese = 0.30;}
        }

        return hasExtraCheese ? costOfExtraCheese + cost*cheeses.size() : cost*cheeses.size() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sandwich sandwich)) return false;
        return isToasted == sandwich.isToasted && hasExtraMeat == sandwich.hasExtraMeat && hasExtraCheese == sandwich.hasExtraCheese && bread == sandwich.bread && Objects.equals(regularToppings, sandwich.regularToppings) && Objects.equals(meats, sandwich.meats) && Objects.equals(cheeses, sandwich.cheeses) && Objects.equals(sauces, sandwich.sauces) && Objects.equals(sides, sandwich.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bread, isToasted, hasExtraMeat, hasExtraCheese, regularToppings, meats, cheeses, sauces, sides);
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "size=" + size +
                ", bread=" + bread +
                ", isToasted=" + isToasted +
                ", hasExtraMeat=" + hasExtraMeat +
                ", hasExtraCheese=" + hasExtraCheese +
                ", regularToppings=" + regularToppings +
                ", meats=" + meats +
                ", cheeses=" + cheeses +
                ", sauces=" + sauces +
                ", sides=" + sides +
                ", cost= $"+getCost()
                +'}';
    }
}
