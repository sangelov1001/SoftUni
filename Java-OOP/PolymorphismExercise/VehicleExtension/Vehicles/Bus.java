package PolymorphismExercise.VehicleExtension.Vehicles;

public class Bus extends VehicleImpl {

    // поле за това дали автобуса е празен или има хора
    private boolean isEmpty;
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.4;


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = false;
    }

    // override-ваме си метода setFuelConsumption()
    // както при Car and Truck си сетваме горивото конкретно за колата и камиончето и тук сетваме за автобуса

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if (!this.isEmpty) {
            super.setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
        }
    }

    public void setEmpty(boolean empty) {
        // it was empty && it is empty -> must
        if (this.isEmpty == empty) {
            return;
        }
        // it was empty && we want to make it full
        if(this.isEmpty && !empty) {
            super.setFuelConsumption(super.getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
        }
        if(!this.isEmpty && empty) {
            super.setFuelConsumption(super.getFuelConsumption() - AC_ADDITIONAL_CONSUMPTION);
        }
        this.isEmpty = empty;
    }
}
