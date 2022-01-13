package PolymorphismExercise.VehicleExtension.Vehicles;

public class Car extends VehicleImpl {

    private static final Double AC_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    // това означава че като си създадем кола ще си имаме вече тези 0,9 литра отгоре
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

}

