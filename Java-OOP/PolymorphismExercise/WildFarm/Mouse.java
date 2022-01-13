package PolymorphismExercise.WildFarm;

import org.w3c.dom.ls.LSOutput;

public class Mouse extends Mammal {

    public Mouse(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEEK");
    }

    // това го пишем и в класа Tiger защото те не ядат зеленчуци
    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Mice do not eat that type of food!");
        }
        super.eat(food);
    }
}
