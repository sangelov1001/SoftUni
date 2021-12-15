package abstractionExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JediGalaxy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int row = dimensions[0];
        int col = dimensions[1];

        // Field field = new Field(rows, cols)
        // Galaxy galaxy = new Galaxy(field)

        int[][] galaxy = new int[row][col]; // игралното поле

        int value = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                galaxy[i][j] = value++;
            }
        }

        String command = scanner.nextLine();
        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {

                int[] jediPosition = readPositions(command);
                int[] evilPosition = readPositions(scanner.nextLine());
                int rowEvil = evilPosition[0];
                int colEvil = evilPosition[1];

                // прочитаме движението и движим злата сила
                while (rowEvil >= 0 && colEvil >= 0) {
                    if (isInBound(rowEvil, colEvil, galaxy)) {
                        galaxy[rowEvil][colEvil] = 0;

                    }
                    rowEvil--;
                    colEvil--;
                }
                // прочитаме пътя на джедая и го движим.
                int rowJedi = jediPosition[0];
                int colJedi = jediPosition[1];

                while (rowJedi >= 0 && colJedi >= 0) {
                    if (isInBound(rowJedi, colJedi, galaxy)) {
                        starsCollected += galaxy[rowJedi][colJedi];
                    }
                    colJedi++;
                  rowJedi--;
                }
                command = scanner.nextLine();
        }
        System.out.println(starsCollected);
    }
    private static int[] readPositions(String command){
         return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    private static boolean isInBound(int row, int col, int[][] galaxy) {
        return  row >= 0 && col >= 0 && row < galaxy.length && col < galaxy[row].length;
    }
}
