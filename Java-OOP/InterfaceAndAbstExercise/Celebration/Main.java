package InterfaceAndAbstExercise.Celebration;

import com.sun.source.tree.WhileLoopTree;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                // Вместо да използваме два списъка и да въртим през тях то ще направим един списък от обекти
                // които са Birthable
                List<Birthable> thingsWithBirthday = new ArrayList<>();
           //     List<Pet> pets = new ArrayList<>();

            while (!input.equals("End")) {
                String[] tokens = input.split(" ");

                // проверяваме дали е човек робот или животинче
                String objectType = tokens[0];

                switch (objectType) {

                    case "Citizen":
                        String citizenName = tokens[1];
                       int citizenAge = Integer.parseInt(tokens[2]);
                        String citizenId = tokens[3];
                        String citizenBirthDate = tokens[4];
                        Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                        thingsWithBirthday.add(citizen);
                        break;
                    case "Pet":
                        String petName = tokens[1];
                        String  petBirthDate = tokens[2];
                        Pet pet = new Pet(petName, petBirthDate);
                        thingsWithBirthday.add(pet);
                        break;
                    case "Robot":
                        String robotModel = tokens[1];
                        String robotId = tokens[2];
                        Robot robot = new Robot(robotModel, robotId);
                        break;
                }
                input = scanner.nextLine();
            }

            String year = scanner.nextLine();
            boolean isFound = false;

            for (Birthable thingWithBirthday : thingsWithBirthday) {
                if (thingWithBirthday.getBirthDate().endsWith(year)) {
                    isFound = true;
                    System.out.println(thingWithBirthday.getBirthDate());
                }
            }

            if (!isFound) {
                System.out.println("<no output>");
            }

            /* for (Pet pet : pets) {
                    if(pets.getBirthDay().endsWith(year)) {
                                 sout...
                                 */
    }
}

