package PolymorphismExercise.Vehicles;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {

    private static final Double AC_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    // това означава че като си създадем кола ще си имаме вече тези 0,9 литра отгоре
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

}

