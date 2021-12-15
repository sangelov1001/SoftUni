package abstractionExercises;

public class Season {

   private String[] month;
   private String name;
   private double averageTemp;

    public String[] getMonth() {
        return month;
    }

    public void setMonth(String[] month) {
        this.month = month;
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

    public Season(String name, double averageTemp, String... month) {
        this.month = month;
        this.name = name;
        this.averageTemp = averageTemp;
    }
}
