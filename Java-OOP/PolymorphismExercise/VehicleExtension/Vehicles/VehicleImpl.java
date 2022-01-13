package PolymorphismExercise.VehicleExtension.Vehicles;


import java.text.DecimalFormat;

// всеки метод в VehicleImpl има имплементация -> може да е обикновен клас, не abstract
public class VehicleImpl implements Vehicle {

    // другия вариант е да направим директно абстрактен клас вместо Интерфейс
    // за да добавим полетата
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity; // резервоар

    // дефинираме как може да си създаваме превозното средство
    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
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
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        // по този начин събираме литрите който имаме в резервоара с тези който се опитват да ни добавят
        double newFuelQuantity = this.fuelQuantity + liters;
        if (newFuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        // ако не хвърли exception горе то значи тези литри ги добавяме в резервоара
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
