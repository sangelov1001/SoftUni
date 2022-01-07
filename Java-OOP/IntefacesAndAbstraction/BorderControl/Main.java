package IntefacesAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiers> identifiables = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            // проверява се дали е робот или гражданин
            Identifiers identifiable = tokens.length == 2
                    ? new Robot(tokens[0], tokens[1])
                    : new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            identifiables.add(identifiable);

            line = scanner.nextLine();
        }

        String fakeLastDigits = scanner.nextLine();
        System.out.println(identifiables.stream()
                .map(Identifiers::getID)
                .filter(id -> id.endsWith(fakeLastDigits))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
