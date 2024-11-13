package com.pluralsight;

import com.pluralsight.enums.ChipType;
import com.pluralsight.enums.Size;

import javax.swing.*;
import java.awt.*;

public class AddChipsGUI {
    public static void addChips(Order order){

        Size size = selectChipsSize();
        ChipType type = selectChipType();
        Chips chips = new Chips(size,type);
        order.addItem(chips);
        GraphicalUserInterface.orderScreen(order);
    }

    public static Size selectChipsSize(){
        Size[] size = {Size.Small};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Select Chips Size");

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
        myFrame.pack();
        myFrame.setVisible(true);

        return size[0];
    }

    public static ChipType selectChipType(){
        ChipType[] type = {ChipType.steak_fries};
        JDialog myFrame = new JDialog();
        myFrame.setLayout(new BorderLayout());
        myFrame.setTitle("Select Chip Type");

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        JButton b1 = new JButton("Curly fries");
        b1.addActionListener(e ->{ type[0] = ChipType.curly_fries; myFrame.dispose();} );
        JButton b2 = new JButton("Steak fries");
        b2.addActionListener(e ->{ type[0] = ChipType.steak_fries; myFrame.dispose();} );
        JButton b3 = new JButton("Potato Wedges");
        b3.addActionListener(e ->{ type[0] = ChipType.potato_wedges; myFrame.dispose();} );
        panel.add(b1); panel.add(b2); panel.add(b3);
        myFrame.add(panel, BorderLayout.CENTER);

        myFrame.setModal(true);
        myFrame.pack();
        myFrame.setVisible(true);

        return type[0];
    }
}
