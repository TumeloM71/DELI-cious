package com.pluralsight.GUIClasses;

import com.pluralsight.FoodClasses.Chips;
import com.pluralsight.Order;
import com.pluralsight.enums.ChipType;
import com.pluralsight.enums.Size;

import javax.swing.*;
import java.awt.*;

/**
 * Class for adding chips to a user's Order with GUI elements
 * @author Tumelo Marongwe
 */
public class AddChipsGUI {
    public static void addChips(Order order){

        Size size = selectChipsSize();
        ChipType type = selectChipType();
        Chips chips = new Chips(size,type);
        order.addItem(chips);
        GraphicalUserInterface.orderScreen(order);
    }

    /**
     * Get the portion size from the customer
      * @return the chips Size
     */
    public static Size selectChipsSize(){
        //Used an array, so I could change the value in the lambda expression
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
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return size[0];
    }

    /**
     *
     * @return the ChipType selected by the user
     */
    public static ChipType selectChipType(){
        //Used an array, so I could change the value in the lambda expression
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
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return type[0];
    }
}
