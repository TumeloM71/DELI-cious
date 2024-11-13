package com.pluralsight.GUIClasses;

import com.pluralsight.FoodClasses.Sandwich;
import com.pluralsight.Order;
import com.pluralsight.enums.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class for adding a Sandwich to a user's Order with GUI elements
 * @author Tumelo Marongwe
 */
public class AddSandwichGUI {

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

    public static Size selectSandwichSize(){
        Size[] size = {Size.Small};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sandwich Size");

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        JButton b1 = new JButton("Small( 4 inches)");
        b1.addActionListener(e ->{ size[0] = Size.Small; myFrame.dispose();} );
        JButton b2 = new JButton("Medium( 8 inches)");
        b2.addActionListener(e ->{ size[0] = Size.Medium; myFrame.dispose();} );
        JButton b3 = new JButton("Large(12 inches)");
        b3.addActionListener(e ->{ size[0] = Size.Large; myFrame.dispose();} );
        panel.add(b1); panel.add(b2); panel.add(b3);
        myFrame.add(panel, BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return size[0];
    }

    public static Bread selectSandwichBread(){

        Bread[] bread = {Bread.wheat};

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sandwich Bread");
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);

        JButton b1 = new JButton("White");
        b1.addActionListener(e ->{ bread[0] = Bread.white; myFrame.dispose();} );
        JButton b2 = new JButton("Wheat");
        b2.addActionListener(e ->{  bread[0] = Bread.wheat; myFrame.dispose();});
        JButton b3 = new JButton("Rye");
        b3.addActionListener(e ->{ bread[0] = Bread.rye; myFrame.dispose();});
        JButton b4 = new JButton("Wrap");
        b4.addActionListener(e ->{ bread[0] = Bread.wrap; myFrame.dispose();} );
        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4);
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
            myFrame.dispose();} );

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        panel.add(b6);
        myFrame.add(panel);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }
    public static void selectMeatToppings(Sandwich sandwich){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Premium meat toppings");
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);

        JButton b1 = new JButton("steak");
        b1.addActionListener( e -> sandwich.addMeatGUI(Meat.steak));
        JButton b2 = new JButton("ham");
        b2.addActionListener( e -> sandwich.addMeatGUI(Meat.ham));
        JButton b3 = new JButton("salami");
        b3.addActionListener( e -> sandwich.addMeatGUI(Meat.salami));
        JButton b4 = new JButton("roast beef");
        b4.addActionListener(e -> sandwich.addMeatGUI(Meat.roastBeef));
        JButton b5 = new JButton("chicken");
        b5.addActionListener( e -> sandwich.addMeatGUI(Meat.chicken));
        JButton b6 = new JButton("bacon");
        b6.addActionListener(e -> sandwich.addMeatGUI(Meat.bacon));
        JButton b7 = new JButton("Done");
        b7.addActionListener( e -> { myFrame.dispose(); extraMeatPopUp(sandwich);toppingsAndSaucesMenu(sandwich);} );

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        panel.add(b6); panel.add(b7);
        myFrame.add(panel,BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

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

        JButton b1 = new JButton("american");
        b1.addActionListener( e -> sandwich.addCheeseGUI(Cheeses.american));
        JButton b2 = new JButton("provolone");
        b2.addActionListener(  e -> sandwich.addCheeseGUI(Cheeses.provolone));
        JButton b3 = new JButton("cheddar");
        b3.addActionListener(  e -> sandwich.addCheeseGUI(Cheeses.cheddar));
        JButton b4 = new JButton("swiss");
        b4.addActionListener(  e -> sandwich.addCheeseGUI(Cheeses.swiss));
        JButton b5 = new JButton("Done");
        b5.addActionListener(  e -> { myFrame.dispose(); extraCheesePopUp(sandwich); toppingsAndSaucesMenu(sandwich);} );

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        myFrame.add(panel, BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

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

    public static void selectRegularToppings(Sandwich sandwich){

        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Free Regular toppings");
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);

        JButton b1 = new JButton("lettuce");
        b1.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.lettuce));
        JButton b2 = new JButton("peppers");
        b2.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.peppers));
        JButton b3 = new JButton("onions");
        b3.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.onions));
        JButton b4 = new JButton("tomatoes");
        b4.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.tomatoes));
        JButton b5 = new JButton("jalapenos");
        b5.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.jalepenos));
        JButton b6 = new JButton("cucumbers");
        b6.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.cucumbers));
        JButton b7 = new JButton("pickles");
        b7.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.pickles));
        JButton b8 = new JButton("guacamole");
        b8.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.guacamole));
        JButton b9 = new JButton("mushrooms");
        b9.addActionListener( e -> sandwich.addRegularToppingsGUI(RegularToppings.mushrooms));
        JButton b0 = new JButton("Done");
        b0.addActionListener( e ->{  myFrame.dispose(); toppingsAndSaucesMenu(sandwich);});

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        panel.add(b6); panel.add(b7); panel.add(b8); panel.add(b9); panel.add(b0);
        myFrame.add(panel,BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    public static void selectSides(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sides");
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);

        JButton b1 = new JButton("au jus");
        b1.addActionListener( e -> sandwich.addSideGUI(Sides.au_jus));
        JButton b2 = new JButton("sauce");
        b2.addActionListener( e -> sandwich.addSideGUI(Sides.sauce));
        JButton b0 = new JButton("Done");
        b0.addActionListener( e ->{  myFrame.dispose(); toppingsAndSaucesMenu(sandwich);});

        panel.add(b1); panel.add(b2); panel.add(b0);
        myFrame.add(panel,BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    public static void selectSauces(Sandwich sandwich){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Sides");
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);

        JButton b1 = new JButton("mayo");
        b1.addActionListener( e -> sandwich.addSauceGUI(Sauces.mayo));
        JButton b2 = new JButton("mustard");
        b2.addActionListener( e -> sandwich.addSauceGUI(Sauces.mustard));
        JButton b3 = new JButton("ketchup");
        b3.addActionListener( e -> sandwich.addSauceGUI(Sauces.ketchup));
        JButton b4 = new JButton("ranch");
        b4.addActionListener( e -> sandwich.addSauceGUI(Sauces.ranch));
        JButton b5 = new JButton("thousand islands");
        b5.addActionListener( e -> sandwich.addSauceGUI(Sauces.thousandIslands));
        JButton b6 = new JButton("vinaigrette");
        b6.addActionListener( e -> sandwich.addSauce(Sauces.vinaigrette));
        JButton b0 = new JButton("Done");
        b0.addActionListener( e ->{  myFrame.dispose(); toppingsAndSaucesMenu(sandwich);});

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        panel.add(b6); panel.add(b0);
        myFrame.add(panel,BorderLayout.CENTER);


        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }
}