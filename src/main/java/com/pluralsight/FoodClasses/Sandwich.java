package com.pluralsight.FoodClasses;

import com.pluralsight.Product;
import com.pluralsight.enums.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sandwich extends Product {

    private Bread bread;
    private boolean isToasted;
    private boolean hasExtraMeat;
    private boolean hasExtraCheese;
    private List<RegularToppings> regularToppings;
    private List<Meat> meats;
    private List<Cheeses> cheeses;
    private List<Sauces> sauces;
    private List<Sides> sides;

    public Sandwich(){};

    public Sandwich(Size size, Bread bread, boolean isToasted) {
        super(size);
        this.bread = bread;
        this.isToasted = isToasted;
        regularToppings = new ArrayList<>();
        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
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

    /**
     * Add regular toppings to the sandwich
     * @param t topping to add
     */
    public void addRegularToppings(RegularToppings t) {
        if (!regularToppings.contains(t)) {
            regularToppings.add(t);
            System.out.println("Added successfully");
        } else
            System.out.println("Topping was already present");
    }

    /**
     * Add regular toppings to the sandwich with GUI elements
     * @param t topping to add
     */
    public void addRegularToppingsGUI(RegularToppings t) {
        if (!regularToppings.contains(t)) {
            regularToppings.add(t);
            JOptionPane.showMessageDialog(null, "Added successfully");
        } else
            JOptionPane.showMessageDialog(null, "Topping was already present");
    }

    /**
     * Remove regular toppings from the sandwich
     * @param t topping to add
     */
    public void removeRegularTopping(RegularToppings t) {
        if (regularToppings.remove(t))
            JOptionPane.showMessageDialog(null, "Removed successfully");
        else
            JOptionPane.showMessageDialog(null, "Item not present");
    }

    /**
     * Add meat toppings to the sandwich
     * @param meat topping to add
     */
    public void addMeat(Meat meat) {
        if (!meats.contains(meat)) {
            meats.add(meat);
            System.out.println("Added successfully");
        } else
            System.out.println("Topping was already present");
    }

    /**
     * Add meat toppings to the sandwich with GUI elements
     * @param meat topping to add
     */
    public void addMeatGUI(Meat meat) {
        if (!meats.contains(meat)) {
            meats.add(meat);
            JOptionPane.showMessageDialog(null, "Added successfully");
        } else
            JOptionPane.showMessageDialog(null, "Topping was already present");
    }

    public void removeMeat(Meat meat) {

        if (meats.remove(meat))
            JOptionPane.showMessageDialog(null, "Removed successfully");
        else
            JOptionPane.showMessageDialog(null, "Item not present");
    }

    /**
     * Add cheese toppings to the sandwich
     * @param cheese topping to add
     */
    public void addCheese(Cheeses cheese) {
        if (!cheeses.contains(cheese)) {
            cheeses.add(cheese);
            System.out.println("Added successfully");
        } else
            System.out.println("Topping was already present");

    }

    /**
     * Add cheese toppings to the sandwich
     * @param cheese topping to add
     */
    public void addCheeseGUI(Cheeses cheese) {
        if (!cheeses.contains(cheese)) {
            cheeses.add(cheese);
            JOptionPane.showMessageDialog(null, "Added successfully");
        } else
            JOptionPane.showMessageDialog(null, "Topping was already present");

    }


    public void removeCheese(Cheeses cheese) {
        if (cheeses.remove(cheese))
            JOptionPane.showMessageDialog(null, "Removed successfully");
        else
            JOptionPane.showMessageDialog(null, "Item not present");
    }

    /**
     * Add sauces to the sandwich
     * @param sauce sauce to add
     */
    public void addSauce(Sauces sauce) {
        if (!sauces.contains(sauce)) {
            sauces.add(sauce);
            System.out.println("Added successfully");
        } else
            System.out.println("Sauce was already present");

    }

    /**
     * Add sauces to the sandwich with GUI elements
     * @param sauce sauce to add
     */
    public void addSauceGUI(Sauces sauce) {
        if (!sauces.contains(sauce)) {
            sauces.add(sauce);
            JOptionPane.showMessageDialog(null, "Added successfully");
        } else
            JOptionPane.showMessageDialog(null, "Topping was already present");

    }

    public void removeSauce(Sauces sauce) {
        if (sauces.remove(sauce))
            JOptionPane.showMessageDialog(null, "Removed successfully");
        else
            JOptionPane.showMessageDialog(null, "Item not present");
    }

    /**
     * Add sides to the sandwich
     * @param side side to add
     */
    public void addSide(Sides side) {
        if (!sides.contains(side)) {
            sides.add(side);
            System.out.println("Added successfully");
        } else
            System.out.println("Side was already present");

    }

    /**
     * Add sides to the sandwich with GUI elements
     * @param side to add
     */
    public void addSideGUI(Sides side) {
        if (!sides.contains(side)) {
            sides.add(side);
            JOptionPane.showMessageDialog(null, "Added successfully");
        } else
            JOptionPane.showMessageDialog(null, "Topping was already present");

    }

    public void removeSide(Sides side) {
        if (sides.remove(side))
            JOptionPane.showMessageDialog(null, "Removed successfully");
        else
            JOptionPane.showMessageDialog(null, "Item not present");
    }

    @Override
    public double getCost() {
        return getBreadCost() + getCheeseCost() + getMeatCost();
    }

    public double getBreadCost() {
        double cost = -1;
        switch (this.size) {
            case Large -> cost = 8.5;
            case Medium -> cost = 7.0;
            case Small -> cost = 5.5;
        }
        return cost;
    }

    /*Gets the cost of the additional meat toppings taking into account the hasExtraMeat boolean
     */
    public double getMeatCost() {
        double cost = -1;
        double costOfExtraMeat = 0;
        switch (this.size) {
            case Large -> {
                cost = 3.0;
                costOfExtraMeat = 1.5;
            }
            case Medium -> {
                cost = 2.0;
                costOfExtraMeat = 1.0;
            }
            case Small -> {
                cost = 1.0;
                costOfExtraMeat = 0.5;
            }
        }

        return hasExtraMeat ? costOfExtraMeat + cost * meats.size() : cost * meats.size();
    }

    /*Gets the cost of the additional cheese topping taking into account the hasExtraCheese boolean
     */
    public double getCheeseCost() {
        double cost = -1;
        double costOfExtraCheese = 0;
        switch (this.size) {
            case Large -> {
                cost = 2.25;
                costOfExtraCheese = 0.90;
            }
            case Medium -> {
                cost = 1.5;
                costOfExtraCheese = 0.60;
            }
            case Small -> {
                cost = 0.75;
                costOfExtraCheese = 0.30;
            }
        }

        return hasExtraCheese ? costOfExtraCheese + cost * cheeses.size() : cost * cheeses.size();
    }

    public int getSizeInInches(){

        switch (this.size){
            case Small -> {
                return 4;
            }
            case Medium -> {
                return 8;
            }
            case Large -> {
                return 12;
            }
        }
        //Dummy return statement
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sandwich sandwich)) return false;
        if (!super.equals(o)) return false;
        return size == sandwich.getSize() && isToasted() == sandwich.isToasted() && hasExtraMeat() == sandwich.hasExtraMeat() && hasExtraCheese() == sandwich.hasExtraCheese() && getBread() == sandwich.getBread() && Objects.equals(getRegularToppings(), sandwich.getRegularToppings()) && Objects.equals(getMeats(), sandwich.getMeats()) && Objects.equals(getCheeses(), sandwich.getCheeses()) && Objects.equals(getSauces(), sandwich.getSauces()) && Objects.equals(getSides(), sandwich.getSides());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBread(), isToasted(), hasExtraMeat(), hasExtraCheese(), getRegularToppings(), getMeats(), getCheeses(), getSauces(), getSides());
    }

    @Override
    public String toString() {
        return "Sandwich{"+
        "size:" + getSizeInInches() +" inches" +
                ", bread:" + bread +
                ", toasted:" + isToasted +
                ", extraMeat:" + hasExtraMeat +
                ", extraCheese:" + hasExtraCheese + "\n" +
                ", regularToppings:" + regularToppings + "\n" +
                ", meat:" + meats + "\n" +
                ", cheese:" + cheeses + "\n" +
                ", sauces:" + sauces + "\n" +
                ", sides:" + sides + "\n" +
                ", cost: $" +  String.format("%.2f",getCost())
                + '}';
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public boolean hasExtraMeat() {
        return hasExtraMeat;
    }

    public boolean hasExtraCheese() {
        return hasExtraCheese;
    }

    public List<RegularToppings> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<RegularToppings> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public void setMeats(List<Meat> meats) {
        this.meats = meats;
    }

    public List<Cheeses> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<Cheeses> cheeses) {
        this.cheeses = cheeses;
    }

    public List<Sauces> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauces> sauces) {
        this.sauces = sauces;
    }

    public List<Sides> getSides() {
        return sides;
    }

    public void setSides(List<Sides> sides) {
        this.sides = sides;
    }
}
