package IntefacesAndAbstraction.SayHelloExtended;

public abstract class BasePerson implements Person{

        private String name;

        // правим да е protected конструктора за да може само преките наследници да се обръщат към него.
    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }
}
