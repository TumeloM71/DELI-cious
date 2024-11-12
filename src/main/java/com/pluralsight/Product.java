package com.pluralsight;

import com.pluralsight.enums.Size;

public abstract class Product {
    Size size;

    public Product(Size size) {
        this.size = size;
    }

    public abstract double getCost();
}
