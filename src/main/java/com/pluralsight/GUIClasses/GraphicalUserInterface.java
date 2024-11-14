package com.pluralsight.GUIClasses;

import com.pluralsight.Order;
import com.pluralsight.HelperClasses.ReceiptWriter;

import javax.swing.*;
import java.awt.*;

/**
 *  Driver class for the GUI
 *  @author Tumelo Marongwe
 */

public class GraphicalUserInterface {

    public static void homeScreen(){
        MyFrame myFrame = new MyFrame();
        myFrame.setTitle("Home");
        myFrame.setLayout(new BorderLayout());
        JLabel title = new JLabel("Welcome to the DELI-cious Sandwich Shop!");
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.ORANGE);
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(100,50));
        panel2.setBackground(Color.GREEN);
        panel2.add(title);
        JButton b1 =  new JButton("New Order.");
        b1.addActionListener(e ->{ newOrderScreen(); myFrame.dispose();} );
        JButton b2 = new JButton("Exit.");
        b2.addActionListener(e -> System.exit(0));
        panel1.add(b1); panel1.add(b2);
        myFrame.add(panel1, BorderLayout.CENTER);
        myFrame.add(panel2, BorderLayout.NORTH);

        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
    }

    public static void newOrderScreen(){

        Order order = new Order();

        MyFrame myFrame = new MyFrame();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Order");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        JButton b1 = new JButton("Add Sandwich");
        b1.addActionListener(e ->{ myFrame.dispose(); AddSandwichGUI.addSandwich(order);} );
        JButton b2 = new JButton("Add Drink");
        b2.addActionListener(e -> {myFrame.dispose(); AddDrinkGUI.addDrink(order);});
        JButton b3 = new JButton("Add chips");
        b3.addActionListener(e -> {myFrame.dispose(); AddChipsGUI.addChips(order);});
        JButton b4 = new JButton("Checkout");
        b4.addActionListener(e -> {myFrame.dispose(); checkOutMenu(order);});
        JButton b5 = new JButton("Cancel order");
        b5.addActionListener( e -> { myFrame.dispose(); order.cancelOrder(); GraphicalUserInterface.homeScreen(); });

        JButton b6 = new JButton("Add Signature Sandwich");
        b6.addActionListener(e -> {myFrame.dispose(); AddSandwichGUI.addSignatureSandwich(order);});

        panel.add(b1); panel.add(b6); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
    }

    public static void orderScreen(Order order){

        MyFrame myFrame = new MyFrame();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Order");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        JButton b1 = new JButton("Add Sandwich");
        b1.addActionListener(e ->{ myFrame.dispose(); AddSandwichGUI.addSandwich(order);} );
        JButton b2 = new JButton("Add Drink");
        b2.addActionListener(e -> {myFrame.dispose(); AddDrinkGUI.addDrink(order);});
        JButton b3 = new JButton("Add chips");
        b3.addActionListener(e -> {myFrame.dispose(); AddChipsGUI.addChips(order);});
        JButton b4 = new JButton("Checkout");
        b4.addActionListener(e -> {myFrame.dispose(); checkOutMenu(order);});
        JButton b5 = new JButton("Cancel order");
        b5.addActionListener( e -> { myFrame.dispose(); order.cancelOrder(); GraphicalUserInterface.homeScreen(); });

        JButton b6 = new JButton("Add Signature Sandwich");
        b6.addActionListener(e -> {myFrame.dispose(); AddSandwichGUI.addSignatureSandwich(order);});

        panel.add(b1); panel.add(b6); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
    }

    public static void checkOutMenu(Order order){
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Confirm checkout");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        JOptionPane.showMessageDialog(null, order);

        JButton b1 = new JButton("Confirm");
        b1.addActionListener(e -> {ReceiptWriter.writeReceipt(order);
        myFrame.dispose(); homeScreen();});
        JButton b2 = new JButton("Cancel");
        b2.addActionListener(e -> { order.cancelOrder(); myFrame.dispose(); GraphicalUserInterface.homeScreen(); });

        panel.add(b1); panel.add(b2);
        myFrame.add(panel, BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

}
