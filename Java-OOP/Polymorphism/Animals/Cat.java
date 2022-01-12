package Polymorphism.Animals;

public class Cat extends Animal{

    // правим си не protected а public конструктора за да може вече Main да си вика котката
    public Cat(String name, String favouriteFood) {
            super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "MEOW";
    }
}
