package InhetiranceExercises.needForSpeed;

public class Car extends Vehicle{

    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    // подсигуряваме си правилния разход за колата чрез сетъра
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
