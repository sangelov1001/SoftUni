package abstractionExercises;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Name
        // Month
        // Average Temp
        /* спестяваме си кода тук в мейна като си добавим енумерациите в отделен клас
               сложим им getter and setter и им зададем стойности.
           */
        List<Season> seasons = new ArrayList<>();
        Season summer = new Season("Summer", 25, "July", "August");
        Season winter = new Season("Winter", 5, "December", "January");

        seasons.add(summer);
        seasons.add(winter);
        System.out.println(Seasons.SUMMER);
        Seasons.SUMMER.ordinal();
    }
}
