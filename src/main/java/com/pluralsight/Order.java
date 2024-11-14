package com.pluralsight;

import com.pluralsight.HelperClasses.ReceiptWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represents the customer's order
 * @author Tumelo Marongwe
 */
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

    /**
    This method maps each item in the order to it's quantity
     */
    public HashMap<Product,Integer> productToQuantityMap(){

        HashMap<Product,Integer> productToQuantity = new HashMap<>();
        for (Product p : items){
            productToQuantity.put(p, productToQuantity.getOrDefault(p, 0)+1);
        }

        return productToQuantity;
    }

    /**
     * List method for the Order items
     */
    public void listOrder(){
        System.out.println("Your order:");

        Map<Product,Integer> productQuantityMap = productToQuantityMap();
        for(Product p : productQuantityMap.keySet()){
            System.out.println(p + " Amount: "+productQuantityMap.get(p));
        }
        double cost = getTotalCost();
        System.out.println("Cost: $"+cost);
    }
    @Override
    public String toString(){

        Map<Product,Integer> productQuantityMap = productToQuantityMap();
        for(Product p : productQuantityMap.keySet()){
            System.out.println(p + " Amount: "+productQuantityMap.get(p));
        }

        StringBuilder output = new StringBuilder();
        productQuantityMap.keySet().forEach(p -> output.append(p).append(" Amount: ")
        .append(productQuantityMap.get(p)).append("\n"));

        output.append(String.format("Cost: $%.2f",getTotalCost()));

        return output.toString();
    }

    /**
     * Check out method
     */
    public void checkOut(){
        ReceiptWriter.writeReceipt(this);
        System.out.println("Checked out successfully.");
        items.clear();
    }
}
