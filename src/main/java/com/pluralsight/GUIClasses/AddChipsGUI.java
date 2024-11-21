package com.pluralsight.GUIClasses;

import com.pluralsight.FoodClasses.Chips;
import com.pluralsight.HelperClasses.Order;
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

        for( ChipType chipType : ChipType.values()){
            JButton b1 = new JButton(chipType.toString());
            b1.addActionListener(e -> {type[0] = chipType; myFrame.dispose();});
            panel.add(b1);
        }

        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.setModal(true);
        myFrame.setSize(new Dimension(400,400));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        return type[0];
    }
}
