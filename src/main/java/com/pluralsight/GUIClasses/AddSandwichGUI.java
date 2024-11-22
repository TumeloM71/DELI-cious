package com.pluralsight.GUIClasses;

import com.pluralsight.FoodClasses.*;
import com.pluralsight.HelperClasses.Order;
import com.pluralsight.enums.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class for adding a Sandwich to a user's Order with GUI elements
 * @author Tumelo Marongwe
 */
public class AddSandwichGUI {

    /**
     *  Menu for adding a Sandwich to the Order
     * @param order the customer's Order
     */
    public static void addSandwich(Order order){

        Size size = selectSandwichSize();
        Bread bread = selectSandwichBread();
        int toastedChoice = JOptionPane.showConfirmDialog(null, "Would you like the sandwich tosted?");
        boolean isToasted = toastedChoice == 0;
        Sandwich sandwich = new Sandwich(size,bread,isToasted);
        toppingsAndSaucesMenu(sandwich);
        order.addItem(sandwich);
        GraphicalUserInterface.orderScreen(order);
    }

    public static void addSignatureSandwich(Order order){

        Sandwich sandwich = signatureSandwichMenu();
        customizeSandwich(sandwich);
        order.addItem(sandwich);
        GraphicalUserInterface.orderScreen(order);
    }

    /**
     * Menu of5 signature sandwiches to chose from
     * @return the chosen Sandwich
     */
    public static Sandwich signatureSandwichMenu(){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Signature Sandwiches");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        Sandwich[] sandwich = {new Sandwich()};

        for( SignatureSandwichMenu s : SignatureSandwichMenu.values()){
            JButton b1 = new JButton(s.toString());
            b1.addActionListener(e -> { myFrame.dispose(); sandwich[0] = s.getSandwich();} );
            panel.add(b1);
        }

        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return sandwich[0];
    }

    /**
     * Menu for adding/removing toppings from the customer's Sandwich
     * @param sandwich the customer's Sandwich
     */
    public static void customizeSandwich(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Customise Sandwich");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        JButton b1 = new JButton("Add toppings");
        b1.addActionListener(e ->{ myFrame.dispose(); toppingsAndSaucesMenu(sandwich);} );
        JButton b2 = new JButton("Remove toppings");
        b2.addActionListener(e -> {myFrame.dispose(); removeToppings(sandwich);});
        JButton b3 = new JButton("Done");
        b3.addActionListener(e -> { myFrame.dispose(); });

        panel.add(b1); panel.add(b2); panel.add(b3);

        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

    /**
     * Method for removing toppings from a sandwich
     * @param sandwich the Sandwich to be modified
     */
    public static void removeToppings(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Remove toppings");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        for (RegularToppings r : sandwich.getRegularToppings()){
            JButton button = new JButton(r.name());
            button.addActionListener(e ->{ sandwich.removeRegularTopping(r); myFrame.dispose();
                removeToppings(sandwich);});
            panel.add(button);
        }

        for (Meat m : sandwich.getMeats()){
            JButton button = new JButton(m.name());
            button.addActionListener(e ->{ sandwich.removeMeat(m); myFrame.dispose();
                removeToppings(sandwich);});
            panel.add(button);
        }

        for (Cheeses c : sandwich.getCheeses()){
            JButton button = new JButton(c.name());
            button.addActionListener(e -> {sandwich.removeCheese(c);myFrame.dispose();
                removeToppings(sandwich);});
            panel.add(button);
        }

        for (Sides s : sandwich.getSides()){
            JButton button = new JButton(s.name());
            button.addActionListener(e -> {sandwich.removeSide(s); myFrame.dispose();
                removeToppings(sandwich);});
            panel.add(button);
        }

        for (Sauces s : sandwich.getSauces()){
            JButton button = new JButton(s.name());
            button.addActionListener(e -> {sandwich.removeSauce(s); myFrame.dispose();
                removeToppings(sandwich);});
            panel.add(button);
        }

        JButton b0 = new JButton("Done");
        b0.addActionListener(e -> {myFrame.dispose(); customizeSandwich(sandwich);});
        panel.add(b0);

        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
    /**
     * Menu for selecting the Sandwich size
     */
    public static Size selectSandwichSize(){
        //Used an array so I could change the value in the lambda expression
        Size[] size = {Size.Small};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sandwich Size");
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);

        for (Size s : Size.values()){
            int sizeInInches = 4;
            switch (s){
                case Small ->{}
                case Medium -> sizeInInches = 8;
                case Large -> sizeInInches = 12;
            }

            JButton b1 = new JButton(s.toString()+String.format(" (%d inches)",sizeInInches));
            b1.addActionListener(e ->{ size[0] = s; myFrame.dispose();} );
            panel.add(b1);
        }

        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return size[0];
    }

    /**
     * Menu for selected the Sandwich BreadType
     */
    public static Bread selectSandwichBread(){

        //Used an array so I could change the value in the lambda expression
        Bread[] bread = {Bread.wheat};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sandwich Bread");
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);

        for (Bread b : Bread.values()){
            JButton b1 = new JButton(b.toString());
            b1.addActionListener(e ->{ bread[0] = b; myFrame.dispose();});
            panel.add(b1);
        }

        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return bread[0];
    }

    public static void toppingsAndSaucesMenu(Sandwich sandwich){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Toppings and Sauces");

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);

        JButton b1 = new JButton("Meat");
        b1.addActionListener( e -> { myFrame.dispose();selectMeatToppings(sandwich);});
        JButton b2 = new JButton("Cheese");
        b2.addActionListener( e -> { myFrame.dispose();selectCheeseToppings(sandwich);});
        JButton b3 = new JButton("Other toppings");
        b3.addActionListener( e ->{ myFrame.dispose(); selectRegularToppings(sandwich);} );
        JButton b4 = new JButton("Sauces");
        b4.addActionListener( e ->{ myFrame.dispose(); selectSauces(sandwich);} );
        JButton b5 = new JButton("Sides");
        b5.addActionListener( e ->{ myFrame.dispose(); selectSides(sandwich);} );
        JButton b6 = new JButton("Done");
        b6.addActionListener(e -> {JOptionPane.showMessageDialog(null, sandwich);
            myFrame.dispose(); customizeSandwich(sandwich);} );

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        panel.add(b6);
        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

    /**
     * Adds the selected meat toppings to the Sandwich
     * @param sandwich the customer's Sandwich
     */
    public static void selectMeatToppings(Sandwich sandwich){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Premium meat toppings");
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);

        for( Meat m : Meat.values()){
            JButton b1 = new JButton(m.toString());
            b1.addActionListener(e -> sandwich.addMeatGUI(m));
            panel.add(b1);
        }

        JButton b7 = new JButton("Done");
        b7.addActionListener( e -> { myFrame.dispose(); extraMeatPopUp(sandwich);toppingsAndSaucesMenu(sandwich);} );
        panel.add(b7);

        myFrame.add(panel,BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

    /**
     * sets the hasExtraMeat boolean after adding meat to the sandwich after prompting the customer
     * @param sandwich the customer's Sanwich
     */
    public static void extraMeatPopUp(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Extra Meat Pop Up");
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);

        JLabel label = new JLabel("Do you want extra meat ?");
        JButton b1 = new JButton("Yes");
        b1.addActionListener(e ->{ sandwich.setHasExtraMeat(true); myFrame.dispose();});
        JButton b2 = new JButton("No");
        b2.addActionListener(e ->{ sandwich.setHasExtraMeat(false); myFrame.dispose();});

        panel.add(label); panel.add(b1); panel.add(b2);

        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

    public static void selectCheeseToppings(Sandwich sandwich){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Premium cheese toppings");
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);

        for( Cheeses ch : Cheeses.values()){
            JButton b1 = new JButton(ch.toString());
            b1.addActionListener(e -> sandwich.addCheeseGUI(ch));
            panel.add(b1);
        }

        JButton b5 = new JButton("Done");
        b5.addActionListener(  e -> { myFrame.dispose(); extraCheesePopUp(sandwich); toppingsAndSaucesMenu(sandwich);} );
        panel.add(b5);

        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    /**
     * Sets the hasExtraCheese boolean after the customer is done adding cheese to their sandwich
     * @param sandwich the customer's Sandwich
     */
    public static void extraCheesePopUp(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Extra Cheese Pop Up");
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);

        JLabel label = new JLabel("Do you want extra cheese ?");
        JButton b1 = new JButton("Yes");
        b1.addActionListener(e ->{ sandwich.setHasExtraCheese(true); myFrame.dispose();});
        JButton b2 = new JButton("No");
        b2.addActionListener(e ->{ sandwich.setHasExtraCheese(false); myFrame.dispose();});

        panel.add(label); panel.add(b1); panel.add(b2);

        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

    /**
     * Adds the selected regular toppings to the Sandwich
     * @param sandwich the customer's Sandwich
     */
    public static void selectRegularToppings(Sandwich sandwich){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Free Regular toppings");
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);

        for (RegularToppings r : RegularToppings.values()){
            JButton b1 = new JButton(r.toString());
            b1.addActionListener(e -> sandwich.addRegularToppings(r));
            panel.add(b1);
        }

        JButton b0 = new JButton("Done");
        b0.addActionListener( e ->{  myFrame.dispose(); toppingsAndSaucesMenu(sandwich);});
        panel.add(b0);

        myFrame.add(panel,BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    /**
     * Adds the selected sides to the Sandwich
     * @param sandwich the customer's Sandwich
     */
    public static void selectSides(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sides");
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);

        for (Sides s : Sides.values()){
            JButton b1 = new JButton(s.toString());
            b1.addActionListener(e -> sandwich.addSideGUI(s));
            panel.add(b1);
        }


        JButton b0 = new JButton("Done");
        b0.addActionListener( e ->{  myFrame.dispose(); toppingsAndSaucesMenu(sandwich);});
        panel.add(b0);

        myFrame.add(panel,BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    /**
     * Adds the selected sauces to the Sandwich
     * @param sandwich the customer's Sandwich
     */
    public static void selectSauces(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sides");
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);

        for (Sauces s : Sauces.values())
        {
            JButton b1 = new JButton(s.toString());
            b1.addActionListener(e -> sandwich.addSauceGUI(s));
            panel.add(b1);
        }
        JButton b0 = new JButton("Done");
        b0.addActionListener( e ->{  myFrame.dispose(); toppingsAndSaucesMenu(sandwich);});
        panel.add(b0);

        myFrame.add(panel,BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }
}
