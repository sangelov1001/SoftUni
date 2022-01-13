package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    // правим toString метода в Mammal защото ни е нужно и полето livingRegion
    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", getType(), getName(),
                formatter.format(getWeight()), this.livingRegion, getFoodEaten());
    }

    // за да може това getter-че да си го използваме в класа Cat
    public String getLivingRegion() {
        return livingRegion;
    }
}
