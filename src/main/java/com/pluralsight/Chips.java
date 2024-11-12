package com.pluralsight;

import com.pluralsight.enums.ChipType;
import com.pluralsight.enums.Size;

public class Chips extends Product{

    ChipType type;

    public Chips(Size size, ChipType type) {
        super(size);
        this.type = type;
    }

    @Override
    public double getCost() {
        return 1.5;
    }

    @Override
    public String toString() {
        return "Chips{" + type +
                ", " + size +
                ", $" + this.getCost()+"}";
    }
}
