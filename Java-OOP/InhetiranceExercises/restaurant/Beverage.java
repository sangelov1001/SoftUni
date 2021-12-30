package InhetiranceExercises.restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {

    private double mililitres;

    public Beverage(String name, BigDecimal price, double mililitres) {
        super(name, price);
        this.mililitres = mililitres;
    }

    public double getMililitres() {
        return mililitres;
    }
}
