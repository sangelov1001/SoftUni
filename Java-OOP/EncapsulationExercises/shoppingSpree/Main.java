package EncapsulationExercises.shoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read people
        Map<String, Person> peopleInfo = new LinkedHashMap<>();
        Map<String, Product> productsInfo = new HashMap<>();


        // Peter=11;George=4
        String[] people = scanner.nextLine().split("\\s+");
        for (String element : people) {
            // Peter=11
            String[] personData = element.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            // създаване си човека
            try {
                Person person = new Person(name, money);
                peopleInfo.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        // Bread=10;Milk=2
        String[] products = scanner.nextLine().split(";");
        for (String element : products) {
            // Bread=10
            String[] productData = element.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            // създаваме си продукт

            try {
                Product product = new Product(name, cost);
                productsInfo.put(name, product);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        // Shopping
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            // Peter Milk
            // Maria Coffee
            String[] commandParts = command.split(" ");
            String personName = commandParts[0];
            String productName = commandParts[1];
            // взиаме името на човека от нашия Map и съответно той купува този продукт
            try {
                // от Map-a ни с хора взимаме човека и му казваме купи еди какво си.
                Person person = peopleInfo.get(personName);
                Product product = productsInfo.get(productName);
               person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }

        // Printing
        for (Person person : peopleInfo.values()) { // взимаме всеки един човек от списъка ни с хора
            System.out.println(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }
    }
}
