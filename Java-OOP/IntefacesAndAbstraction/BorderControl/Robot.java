package IntefacesAndAbstraction.BorderControl;

public class Robot implements Identifiers {

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }


    @Override
    public String getID() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }
}
