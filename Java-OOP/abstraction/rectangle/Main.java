package abstraction.rectangle;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       int[] coordinates = readArray(scanner);

       // създадохме си двете точки в класа Point и сега тук ги описваме
       Point pointA = new Point(coordinates[0], coordinates[1]);
       Point pointC = new Point(coordinates[2], coordinates[3]);

       // първо създаваме координатите в другите класове (Point, Rectangle) и след това тук създаваме комнструктор с тези координати
        Rectangle rectangle = new Rectangle(pointA, pointC);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            // тук си четем данните които ни дават по условие да проверяваме
           int[] tokens = readArray(scanner);

           Point p = new Point(tokens[0], tokens[1]);

           boolean isInside = rectangle.isInside(p);
            System.out.println(isInside);
        }
    }
    public static int[] readArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
