package PolymorphismExercise.VehicleExtension.Vehicles;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        Vehicle car = getVehicle(tokens);

        // четем си следващо превозно средство
        tokens = scanner.nextLine().split(" ");
        Vehicle truck = getVehicle(tokens);

        tokens = scanner.nextLine().split(" ");
        Vehicle bus = getVehicle(tokens);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split(" ");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            Vehicle vehicle = vehicles.get(vehicleType);

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    // вместо да проверяваме и да викаме drive метода за всяко едно превозно средство. Слагаме всичко в Map
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(false);
                    }
                    System.out.println(vehicle.drive(distance));
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    try {
                        vehicles.get(vehicleType).refuel(liters);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    // drive without people.
                    double driveEmptyBusDistance = Double.parseDouble(tokens[2]);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(true);
                    }
                    System.out.println(vehicle.drive(driveEmptyBusDistance));
                    break;
                default:
                    throw new IllegalArgumentException("No such command!");
            }
        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(String[] tokens) {

        String vehicleType = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);
        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelAmount, consumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelAmount, consumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelAmount, consumption, tankCapacity);
                break;
        }
        return vehicle;
    }
}
