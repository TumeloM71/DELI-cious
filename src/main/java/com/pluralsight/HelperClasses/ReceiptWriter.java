package com.pluralsight.HelperClasses;

import com.pluralsight.FoodClasses.Product;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReceiptWriter {

    static DateTimeFormatter df = df = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    /**
    Makes a receipt text file for the order
    @param order the Order to write the receipt for
     */
    public static void writeReceipt(Order order){
        try {
            String date = df.format(LocalDateTime.now());
            FileWriter fileWriter = new FileWriter(date+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("DELI-cious Sandwich Shop, Dallas, TX\n");
            String dashedLine = "-".repeat(80);
            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write(dashedLine+"\n");

            bufferedWriter.write("Date & Time: "+date+"\n");
            bufferedWriter.write("Item Count: "+order.getItems().size()+"\n");
            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write(dashedLine+"\n");

            Map<Product,Integer> productQuantityMap = order.productToQuantityMap();
            for(Product p : productQuantityMap.keySet()){
                bufferedWriter.write(p + " Amount: "+productQuantityMap.get(p)+"\n");
                bufferedWriter.write("\n");
            }

            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write(String.format("Total: $%.2f",order.getTotalCost()));
            bufferedWriter.close();
            File receipt = new File(date+".txt");
            Desktop.getDesktop().open(receipt);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
