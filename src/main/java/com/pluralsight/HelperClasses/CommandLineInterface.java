package com.pluralsight.HelperClasses;

import com.pluralsight.FoodClasses.Chips;
import com.pluralsight.FoodClasses.Drink;
import com.pluralsight.FoodClasses.Sandwich;
import com.pluralsight.Order;
import com.pluralsight.enums.*;

import java.util.Scanner;

public class CommandLineInterface {

    static Scanner input = new Scanner(System.in);

    /**
    Displays the CLI version of the home screen
     */
    public static void homeScreen(){
        int selection;
        System.out.println("Welcome to the Sandwich Shop:");
        while (true){
            System.out.println("""
                            1) New order
                            0) Exit"""
            );

            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 -> orderScreen();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }

    /**
    Displays the order screen which lets the customer add items to the order(sandwiches, drinks or chips)
     */
    public static void orderScreen(){

        Order order = new Order();
        while (true){
            System.out.println("""
                    1) Add Sandwich \s
                    2) Add Drink \s
                    3) Add Chips \s
                    4) Checkout \s
                    0) Cancel Order""");
            int userInput = Utilities.getIntValue(input.nextLine().trim());
            switch (userInput){
                case 1 -> addSandwich(order);
                case 2 -> addDrink(order);
                case 3 -> addChips(order);
                case 4 -> checkOutMenu(order);
                case 0 ->{
                    order.cancelOrder();
                    return;
                }
            }
        }
    }

    /**
    Lets the customer confirm their checkout or cancel the order
    @param order the customer's order
     */
    public static void checkOutMenu(Order order){
        int selection;
        order.listOrder();
        System.out.println("""
                1.Confirm \s
                0.Cancel  \s
                """);
        selection = Utilities.getIntValue(input.nextLine().trim());
        switch (selection){
            case 1 ->{ order.checkOut(); homeScreen();}
            case 0 -> { order.cancelOrder();
             homeScreen();}
        }
    }

    /**
    Menu for adding a drink to the customer's order. Asks for drink size and flavor
     @param order the customer's order
     */
    public static void addDrink(Order order){
        System.out.println("""
                Select your drink size:
                1) Small
                2) Medium
                3) Large
                """);

        Size size;
        int sizeChoice = Utilities.getIntValue(input.nextLine().trim());
        switch (sizeChoice) {
            case 1 -> size = Size.Small;
            case 2 -> size = Size.Medium;
            case 3 -> size = Size.Large;
            default -> {size = Size.Medium;
                System.out.println("Invalid choice. Defaulting to Medium size.");}
        }

        System.out.println("""
                Select the flavor:
                1. orange
                2. lime
                3. grape""");
        DrinkFlavor flavor;
        int flavorChoice = Utilities.getIntValue(input.nextLine().trim());
        switch (flavorChoice){
            case 1 -> flavor = DrinkFlavor.orange;
            case 2 -> flavor = DrinkFlavor.lime;
            case 3 -> flavor = DrinkFlavor.grape;
            default -> { flavor = DrinkFlavor.orange;
                        System.out.println("Invalid choice. Defaulting to orange flavor");}
        }

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
    }

    /**
    Method for adding chips to the customer's order. Asks the chip type and portion size
     @param order the customer's order
     */
    public static void addChips(Order order){
        System.out.println("""
                Select your chips' size:
                1) Small
                2) Medium
                3) Large
                """);

        Size size;
        int sizeChoice = Utilities.getIntValue(input.nextLine().trim());
        switch (sizeChoice) {
            case 1 -> size = Size.Small;
            case 2 -> size = Size.Medium;
            case 3 -> size = Size.Large;
            default -> {size = Size.Medium;
                System.out.println("Invalid choice. Defaulting to Medium size.");}
        }

        System.out.println("""
                Select the type of chips:
                1. curly fries,
                2. steak fries,
                3. potato wedges,""");
        ChipType type;
        int typeChoice = Utilities.getIntValue(input.nextLine().trim());
        switch (typeChoice) {
            case 1 -> type = ChipType.curly_fries;
            case 2 -> type = ChipType.steak_fries;
            case 3 -> type = ChipType.potato_wedges;
            default -> { type = ChipType.steak_fries;
                System.out.println("Invalid choice. Defaulting to steak fries.");}
        }

        Chips chips = new Chips(size, type);
        order.addItem(chips);
    }

    /**
    Method for adding a sandwich to the customer's order. Asks for size, bread type and which toppings to add
     @param order the customer's order
     */
    public static void addSandwich(Order order){
        System.out.println("""
                Select your sandwich size:
                1) Small(4 inches)
                2) Medium(8 inches) \s
                3) Large(12 inches) \s
                """);

        Size size;
        int sizeChoice = Utilities.getIntValue(input.nextLine().trim());
        switch (sizeChoice) {
            case 1 -> size = Size.Small;
            case 2 -> size = Size.Medium;
            case 3 -> size = Size.Large;
            default -> {size = Size.Medium;
                System.out.println("Invalid choice. Defaulting to Medium size.");}
        }
        System.out.println("""
                Select your bread:
                1) White
                2) Wheat
                3) Rye
                4) Wrap
                """);

        Bread bread;
        int breadChoice =  Utilities.getIntValue(input.nextLine().trim());
        switch (breadChoice) {
            case 1 ->  bread = Bread.wheat;
            case 2 ->  bread = Bread.white;
            case 3 -> bread = Bread.rye;
            case 4 -> bread = Bread.wrap;
            default -> {bread = Bread.wrap;
                System.out.println("Invalid choice. Defaulting to Wrap.");}
        }
        boolean isToasted;
        System.out.println("Would you like your sandwich to be toasted ?\n"+"1.Yes 2.No");
        int toastedChoice = Utilities.getIntValue(input.nextLine().trim());
        switch (toastedChoice){
            case 1 -> isToasted = true;
            case 2 -> isToasted = false;
            default ->{ isToasted = false;
                System.out.println("Invalid input. Defaulting to not toasted");}
        }
        Sandwich sandwich = new Sandwich(size, bread, isToasted);
        int selection;
        while (true) {
            System.out.println("""
                    Toppings and sides:
                    1.Meat:  \s
                    2.Cheese: \s
                    3.Other toppings: \s
                    4.Select sauces:
                    5.Select sides
                    0.Done""");
            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 -> addMeatToppings(sandwich);
                case 2 -> addCheeseToppings(sandwich);
                case 3 -> addRegularToppings(sandwich);
                case 4 -> addSauces(sandwich);
                case 5 -> addSides(sandwich);
                case 0 -> {
                    order.addItem(sandwich);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    /**
    Method for adding free regular toppings to a Sandwich
     @param sandwich the customer's sandwich
     */
    public static void addRegularToppings(Sandwich sandwich){

        int selection;
        while (true) {
            System.out.println("""
                    Regular toppings:\s
                    \
                    1. lettuce
                    2. peppers
                    3. onions
                    4. tomatoes
                    5. jalepenos
                    6. cucumbers
                    7. pickles
                    8. guacamole
                    9. mushrooms
                    0. Done""");
            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 ->  sandwich.addRegularToppings(RegularToppings.lettuce);
                case 2 -> sandwich.addRegularToppings(RegularToppings.peppers);
                case 3 -> sandwich.addRegularToppings(RegularToppings.onions);
                case 4 -> sandwich.addRegularToppings(RegularToppings.tomatoes);
                case 5 -> sandwich.addRegularToppings(RegularToppings.jalepenos);
                case 6 -> sandwich.addRegularToppings(RegularToppings.cucumbers);
                case 7 -> sandwich.addRegularToppings(RegularToppings.pickles);
                case 8 -> sandwich.addRegularToppings(RegularToppings.guacamole);
                case 9 -> sandwich.addRegularToppings(RegularToppings.mushrooms);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }

    /**
    Method for adding meat toppings to a sandwich
     @param sandwich the customer's sandwich
     */
    public static void addMeatToppings(Sandwich sandwich){

        int selection;
        while (true){
            System.out.println("""
                    Meat toppings:\s
                    1. steak
                    2. ham
                    3. salami
                    4. roastBeef
                    5. chicken
                    6. bacon
                    0. Done""");
            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 -> sandwich.addMeat(Meat.steak);
                case 2 -> sandwich.addMeat(Meat.ham);
                case 3 -> sandwich.addMeat(Meat.salami);
                case 4 -> sandwich.addMeat(Meat.roastBeef);
                case 5 -> sandwich.addMeat(Meat.chicken);
                case 6 -> sandwich.addMeat(Meat.bacon);
                case 0 -> {
                    System.out.println("Would you like extra meat?\n1.Yes 2.No");
                    selection = Utilities.getIntValue(input.nextLine().trim());
                    if (selection == 1)
                        sandwich.setHasExtraMeat(true);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }

    }

    /**
    Method for adding cheese toppings to a Sandwich
     @param sandwich the customer's sandwich
     */
    public static void addCheeseToppings(Sandwich sandwich){

        int selection ;
        while (true){
            System.out.println("""
                    Cheese toppings:
                    1. american,
                    2. provolone,
                    3. cheddar,
                    4. swiss,
                    0. Done""");
            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 -> sandwich.addCheese(Cheeses.american);
                case 2 -> sandwich.addCheese(Cheeses.provolone);
                case 3 -> sandwich.addCheese(Cheeses.cheddar);
                case 4 -> sandwich.addCheese(Cheeses.swiss);
                case 0 -> {
                    System.out.println("Would you like extra cheese?\n1.Yes 2.No");
                    selection = Utilities.getIntValue(input.nextLine().trim());
                    if (selection == 1)
                        sandwich.setHasExtraCheese(true);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }

    /**
    Method for adding sauces to a sandwich
     @param sandwich the customer's sandwich
     */
    public static void addSauces(Sandwich sandwich){

        int selection;
        while (true){
            System.out.println("""
                    Sauces:
                    1. mayo
                    2. mustard
                    3. ketchup
                    4. ranch
                    5. thousandIslands
                    6. vinaigrette
                    0. Done""");
            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 -> sandwich.addSauce(Sauces.mayo);
                case 2 -> sandwich.addSauce(Sauces.mustard);
                case 3 -> sandwich.addSauce(Sauces.ketchup);
                case 4 -> sandwich.addSauce(Sauces.ranch);
                case 5 -> sandwich.addSauce(Sauces.thousandIslands);
                case 6 -> sandwich.addSauce(Sauces.vinaigrette);
                case 0 -> {
                    return;
                }
            }
        }
    }

    /**
    Method for adding sides to a Sandwich
     @param sandwich the customer's sandwich
     */
    public static void addSides(Sandwich sandwich){

        int selection;
        while(true){
            System.out.println("""
                    Sides:
                    1. au jus,
                    2. Sauce
                    0. Done""");
            selection = Utilities.getIntValue(input.nextLine().trim());
            switch (selection){
                case 1 -> sandwich.addSide(Sides.au_jus);
                case 2 -> sandwich.addSide(Sides.sauce);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }
}
