package PolymorphismExercise.Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    // другия вариант е да направим директно абстрактен клас вместо Интерфейс
    // за да добавим полетата
    private double fuelQuantity;
    private double fuelConsumption;

    // дефинираме как може да си създаваме превозното средство
    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }


    // правим си toString метода за да може да го отпечатаме накрая в Main
    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    // this.getClass().getSimpleName()
        // с тази проверка в метода drive си взимаме името дали е кола или камионче
        // с този метод дефинираме как може да го караме
    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling.";
        }
        this.fuelQuantity -= fuelNeeded;

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km.",this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

}
