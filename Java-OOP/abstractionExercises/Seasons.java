package abstractionExercises;

public enum Seasons {

    SUMMER("Summer", 25, "July", "August"),
    WINTER("Winter", 5 , "December"),
    SPRING("Spring" , 10, "May"),
    AUTUMN("Autumn", 8, "September");


   private String[] months;
    private String name;
    private double averageTemp;


    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(double averageTemp) {
        this.averageTemp = averageTemp;
    }

    Seasons(String name, double averageTemp, String... month) {
        this.months = month;
        this.name = name;
        this.averageTemp = averageTemp;
    }
}
