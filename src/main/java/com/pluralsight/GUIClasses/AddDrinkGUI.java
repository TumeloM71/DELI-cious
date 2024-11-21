package com.pluralsight.GUIClasses;

import com.pluralsight.FoodClasses.Drink;
import com.pluralsight.HelperClasses.Order;
import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.Size;

import javax.swing.*;
import java.awt.*;

/**
 * Class for adding drinks to a user's Order with GUI elements
 * @author Tumelo Marongwe
 */
public class AddDrinkGUI {

    public static void addDrink(Order order){

        Size size = selectDrinkSize();
        DrinkFlavor flavor = selectDrinkFlavor();
        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
        GraphicalUserInterface.orderScreen(order);
    }

    public static Size selectDrinkSize(){
        //Used an array, so I could change the value in the lambda expression
        Size[] size = {Size.Small};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Select Drink Size");

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        for (Size s : Size.values()){
            JButton b1 = new JButton(s.toString());
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

    public static DrinkFlavor selectDrinkFlavor(){
        //Used an array so I could change the value in the lambda expression
        DrinkFlavor[] flavor = {DrinkFlavor.lime};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Select Drink Flavor");

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);

        for (DrinkFlavor drinkFlavor: DrinkFlavor.values()){
            JButton b1 = new JButton(drinkFlavor.toString());
            b1.addActionListener(e -> {flavor[0] = drinkFlavor; myFrame.dispose();});
            panel.add(b1);
        }

        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return flavor[0];
    }
}
