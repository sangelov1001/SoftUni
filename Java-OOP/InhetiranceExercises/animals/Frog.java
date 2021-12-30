package InhetiranceExercises.animals;

public class Frog extends Animals {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
   public String produceSound() {
        return "Ribbit";
    }
}
