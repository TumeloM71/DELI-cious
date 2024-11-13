package com.pluralsight.GUIClasses;

import com.pluralsight.FoodClasses.Drink;
import com.pluralsight.Order;
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
        Size[] size = {Size.Small};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Select Drink Size");

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        JButton b1 = new JButton("Small");
        b1.addActionListener(e ->{ size[0] = Size.Small; myFrame.dispose();} );
        JButton b2 = new JButton("Medium");
        b2.addActionListener(e ->{ size[0] = Size.Medium; myFrame.dispose();} );
        JButton b3 = new JButton("Large");
        b3.addActionListener(e ->{ size[0] = Size.Large; myFrame.dispose();} );
        panel.add(b1); panel.add(b2); panel.add(b3);
        myFrame.add(panel, BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return size[0];
    }

    public static DrinkFlavor selectDrinkFlavor(){
        DrinkFlavor[] flavor = {DrinkFlavor.lime};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Select Drink Flavor");

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        JButton b1 = new JButton("Orange");
        b1.addActionListener(e ->{ flavor[0] = DrinkFlavor.orange; myFrame.dispose();} );
        JButton b2 = new JButton("Lime");
        b2.addActionListener(e ->{ flavor[0] = DrinkFlavor.lime; myFrame.dispose();} );
        JButton b3 = new JButton("Grape");
        b3.addActionListener(e ->{ flavor[0] = DrinkFlavor.grape; myFrame.dispose();} );
        panel.add(b1); panel.add(b2); panel.add(b3);
        myFrame.add(panel, BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return flavor[0];
    }
}
