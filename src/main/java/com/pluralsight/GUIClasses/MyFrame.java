
package com.pluralsight.GUIClasses;

import javax.swing.*;
import java.awt.*;
/**
 *  My custom JFrame child class
 *  @author Tumelo Marongwe
 */
public class MyFrame extends JFrame {

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.CYAN);
    }

    public MyFrame(Color color){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(color);
    }
}
