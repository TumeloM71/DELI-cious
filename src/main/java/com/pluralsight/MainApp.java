package com.pluralsight;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {

       int userInterfaceChoice = JOptionPane.showConfirmDialog(null, "Would you like to use the Graphical User Interface?");
       if (userInterfaceChoice == 0)
           GraphicalUserInterface.homeScreen();
       else
           CommandLineInterface.homeScreen();

    }
}
