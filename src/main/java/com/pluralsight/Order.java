package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> items;

    public Order(){

        items = new ArrayList<>();
    }

    public void addItem(Product item){
        items.add(item);
    }

    public void cancelOrder(){
        items.clear();
    }

    public void listOrder(){
        System.out.println("Your order:");
        this.items.forEach(System.out::println);
    }
}
