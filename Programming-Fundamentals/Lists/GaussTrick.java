package Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> streamList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < streamList.size(); i++) {

            if (i == streamList.size() - 1) {
                break;
            }
            int currentElement = streamList.get(i);
            int oppositeElement = streamList.get(streamList.size() - 1);

            streamList.set(i, currentElement + oppositeElement);
            streamList.remove(streamList.size() - 1);
        }

        // печатаме си с foreach-а
        for (Integer number : streamList) {

            System.out.print(number + " ");
        }
    }
}
