package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    static DateTimeFormatter df = df = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

    public static void writeReceipt(Order order){
        try {
            String date = df.format(LocalDateTime.now());
            FileWriter fileWriter = new FileWriter("src/main/resources/receipts/"+date+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);;
            bufferedWriter.write("Date & Time: "+date+"\n");
            bufferedWriter.write("Item Count: "+order.getItems().size()+"\n");
            String dashedLine = "-".repeat(80);
            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write(dashedLine+"\n");
            for ( Product p : order.getItems()){
                bufferedWriter.write(p.toString()+"\n");
            }
            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write(dashedLine+"\n");
            bufferedWriter.write("Total: $"+order.getTotalCost());
            bufferedWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
