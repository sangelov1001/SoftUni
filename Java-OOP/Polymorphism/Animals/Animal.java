package Polymorphism.Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;


    // правим си конструктора да е protected за да не може да се създава директно инстанции от Animal
    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return "I am " + name + " and my favourite food is " + favouriteFood;
    }
}
