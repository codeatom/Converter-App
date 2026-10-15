package main.java.se.lexicon;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CurrencyConverter {

    private static final double SEK_TO_USD_RATE = 10.87;
    private static final double SEK_TO_EUR_RATE = 11.32;
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String convert(Scanner scanner) {
        System.out.println("\n--- Currency Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. SEK to USD");
        System.out.println("  2. SEK to EUR");
        System.out.print("Your choice: ");

        int choice;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter 1 or 2.");
        }

        if (choice == 1) {
            System.out.print("Enter amount in SEK: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric amount.");
                scanner.next();
            }

            double sek = scanner.nextDouble();
            double usd = sekToUsd(sek);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f SEK = %.2f USD%n",
                    sek, usd
            );

            System.out.println(
                    "Converted at: "
                            + LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

            return String.format(
                    Locale.US,
                    "%.2f SEK = %.2f USD  | Converted at: %s",
                    sek, usd, LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

        } else {
            System.out.print("Enter amount in SEK: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric amount.");
                scanner.next();
            }

            double sek = scanner.nextDouble();
            double eur = sekToEur(sek);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f SEK = %.2f EUR%n",
                    sek, eur
            );

            System.out.println(
                    "Converted at: "
                            + LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

            return String.format(
                    Locale.US,
                    "%.2f SEK = %.2f EUR  | Converted at: %s",
                    sek, eur, LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );
        }
    }

    private double sekToUsd(double sek) {
        return sek / SEK_TO_USD_RATE;
    }

    private double sekToEur(double sek) {
        return sek / SEK_TO_EUR_RATE;
    }
}