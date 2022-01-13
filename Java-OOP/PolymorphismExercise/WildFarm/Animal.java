package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {

    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    public Animal(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    // този метод ще се използва за да може да се хранят всички животни от класа.
    // тук добавяме храната която животинката си е яла.
    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }
    // getter са нужни за да може да сетнем тези полета в Mammal


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }
}
