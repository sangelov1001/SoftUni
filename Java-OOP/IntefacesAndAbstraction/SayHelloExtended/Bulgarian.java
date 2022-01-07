package IntefacesAndAbstraction.SayHelloExtended;

public class Bulgarian extends BasePerson {

    public String name;

    public Bulgarian(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Здравей";
    }
}
