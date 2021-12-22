package EncapsulationExercises.shoppingSpree;

public class Product {
    private String name;
    private double cost;


    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
            this.name = name;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }



    public Product(String name, double cost) {
        this.setCost(cost);
        this.setName(name);

    }
}
