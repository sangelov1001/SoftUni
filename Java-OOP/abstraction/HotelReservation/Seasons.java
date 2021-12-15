package abstraction.HotelReservation;

public enum Seasons {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    // правим си поле
    private int multiplier;

    // правим си конструктор
    Seasons(int multiplier) {
        this.multiplier = multiplier;
    }

    // правим getter защото искаме да вземем multiplier и да го използваме
    public int getMultiplier() {
        return multiplier;
    }

    // static защото няма да го извикваме върху други инстанции а само в/у Season
    public static Seasons fromString(String seasonAsString)  {
        return  Seasons.valueOf(seasonAsString.toUpperCase());
    }

}
