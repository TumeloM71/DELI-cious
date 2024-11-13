package com.pluralsight.FoodClasses;

import com.pluralsight.Product;
import com.pluralsight.enums.ChipType;
import com.pluralsight.enums.Size;

import java.util.Objects;

public class Chips extends Product {

    private ChipType type;

    public Chips(Size size, ChipType type) {
        super(size);
        this.type = type;
    }

    @Override
    public double getCost() {
        return 1.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chips chips)) return false;
        if (!super.equals(o)) return false;
        return size == chips.getSize() && getType() == chips.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }

    @Override
    public String toString() {
        return "Chips{Type: " + type +
                ", Size:" + size +
                ", Cost: $" + String.format("%.2f",getCost())+"}";
    }

    public ChipType getType() {
        return type;
    }

    public void setType(ChipType type) {
        this.type = type;
    }
}
