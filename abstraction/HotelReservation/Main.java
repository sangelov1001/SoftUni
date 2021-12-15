package abstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // "{pricePerDay} {numberOfDays} {season} {discountType}

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String season = input[2];
        String discountType = input[3];

        int multiplier  = Seasons.fromString(season).getMultiplier();

    }

    }

