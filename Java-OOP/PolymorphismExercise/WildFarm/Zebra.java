package PolymorphismExercise.WildFarm;

public class Zebra extends Mammal{

    public Zebra(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
            if (food instanceof Meat) {
                throw new IllegalArgumentException("Zebras do not eat that type of food!");
            }
            super.eat(food);
    }
}
