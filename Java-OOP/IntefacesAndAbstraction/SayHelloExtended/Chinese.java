package IntefacesAndAbstraction.SayHelloExtended;

public class Chinese extends BasePerson{

     public String name;

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Mi hao";
    }
}
