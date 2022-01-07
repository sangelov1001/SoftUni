package IntefacesAndAbstraction.BorderControl;

public class Citizen implements Identifiers{

    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getID() {
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
