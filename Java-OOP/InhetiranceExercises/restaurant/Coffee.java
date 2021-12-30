package InhetiranceExercises.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{

    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;


    public Coffee(String name, BigDecimal price, double mililitres) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
    }

    public double getCaffeine() {
        return caffeine;
    }
}
