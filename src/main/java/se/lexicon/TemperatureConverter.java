package main.java.se.lexicon;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TemperatureConverter {

    private static final double FAHRENHEIT_MULTIPLIER = 9.0 / 5.0;
    private static final double CELSIUS_MULTIPLIER = 5.0 / 9.0;
    private static final double FAHRENHEIT_OFFSET = 32.0;
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String convert(Scanner scanner) {
        System.out.println("\n--- Temperature Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Celsius to Fahrenheit");
        System.out.println("  2. Fahrenheit to Celsius");
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
            System.out.print("Enter temperature in Celsius: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric amount.");
                scanner.next();
            }

            double celsius = scanner.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f C = %.2f F%n",
                    celsius, fahrenheit
            );

            System.out.println(
                    "Converted at: "
                            + LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

            return String.format(
                    Locale.US,
                    "%.2f C = %.2f F  | Converted at: %s",
                    celsius, fahrenheit, LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

        } else {
            System.out.print("Enter temperature in Fahrenheit: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric amount.");
                scanner.next();
            }

            double fahrenheit = scanner.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f F = %.2f C%n",
                    fahrenheit, celsius
            );

            System.out.println(
                    "Converted at: "
                            + LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

            return String.format(
                    Locale.US,
                    "%.2f F = %.2f C  | Converted at: %s",
                    fahrenheit, celsius, LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * FAHRENHEIT_MULTIPLIER
                + FAHRENHEIT_OFFSET;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_OFFSET)
                * CELSIUS_MULTIPLIER;
    }
}