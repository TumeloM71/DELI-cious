package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> items;

    public Order(){

        items = new ArrayList<>();
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product item){
        items.add(item);
    }

    public void cancelOrder(){
        items.clear();
    }

    public double getTotalCost(){
        return items.stream().mapToDouble(Product::getCost).reduce(0, Double::sum);
    }

    public void listOrder(){
        System.out.println("Your order:");
        this.items.forEach(System.out::println);
        System.out.println();
        double cost = getTotalCost();
        System.out.println("Cost: $"+cost);
    }

    public void checkOut(){
        ReceiptWriter.writeReceipt(this);
        System.out.println("Checked out successfully.");
        items.clear();
    }
}
