package com.pluralsight.FoodClasses;

import com.pluralsight.enums.Size;

import java.util.Objects;

/**
 *  Abstract class for Sandwich Shop products
 *  @author Tumelo Marongwe
 */
public abstract class Product {
    protected Size size;

    public Product(){}

    public Product(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return size == product.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }

    public abstract double getCost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
