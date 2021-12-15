package abstractionExercises.trafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // четем списък от цветове (RED GREEN YELLOW)
        Color[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Color::valueOf)
                .toArray(Color[]::new);

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (Color color : signals) {
            // създаваме си светофар за всяка светлина
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {   // тук въртим цикъла колкото пъти зададем да се въртят всички светлини(n)

            for (TrafficLight trafficLight : trafficLights) { // при всяко въртене сменя цветовете
                trafficLight.changeColor();
                System.out.print(trafficLight + " ");
            }
            System.out.println();
        }
    }
}
