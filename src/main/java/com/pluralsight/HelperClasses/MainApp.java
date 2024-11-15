package com.pluralsight.HelperClasses;

import com.pluralsight.GUIClasses.GraphicalUserInterface;

import javax.swing.*;

/**
 *  Driver app for the whole program
 *  @author Tumelo Marongwe
 */
public class MainApp {

    /**
     *User can choose between a Command Line Interface or a Graphical User Interface
     */
    public static void main(String[] args) {

       int userInterfaceChoice = JOptionPane.showConfirmDialog(null, "Would you like to use the Graphical User Interface?");
       if (userInterfaceChoice == 0)
           GraphicalUserInterface.homeScreen();
       else
           CommandLineInterface.homeScreen();


    }
}
