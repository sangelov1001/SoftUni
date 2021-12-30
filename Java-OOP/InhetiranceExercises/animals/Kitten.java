package InhetiranceExercises.animals;

public class Kitten extends Cat{

    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    // правим си и конструктор на самия клас, който не го наследяваме
    public Kitten(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
