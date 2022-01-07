package IntefacesAndAbstraction.Ferrari;

public class Ferrari implements Car{

    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    @Override
    public String breaks() {
        return "Breaks!";
    }

    @Override
    public String gas() {
        return "Brum-brum-brrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s%s/%s",
                model, breaks(), gas(), driverName);
    }
}
