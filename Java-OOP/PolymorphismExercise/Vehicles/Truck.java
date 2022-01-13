package PolymorphismExercise.Vehicles;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl{

    // използваме наимонавания за променливите защото не е хубаво в кода да има оставени просто числа
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    // тук сетваме горивото на камиончето
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

    // преизползваме си refuel метода от абстрактния клас и умножаваме по 0,95. така взимаме 95 % от него.
    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUEL_PERCENTAGE);
    }

}
