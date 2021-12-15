package abstraction.HotelReservation;

public enum Discount {
    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0.0);

    // същата логика като при Seasons
    private double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    //public static Discount fromString(String discountAsString) {
                // тук поради това че е на джава 11 а не 17 не става switch expression-а
    // логиката тукк е същата като при Seasons
        };


