package IntefacesAndAbstraction.carShop;

public class Seat extends CarImpl implements Sellable{


    private final Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    // всеки от класовете ауди и сеат си правят собствен override на to String за да се добави
    // допълнителна информация за конкретната кола
    // затова си го правим в техния си клас (Audi Seat)
    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + getModel() + " sells for " + price;
    }
}
