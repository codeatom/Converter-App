package main.java.se.lexicon;

import java.util.Scanner;
import java.util.Locale;

public class ConverterApp {

    // Conversion rates and fixed values
    private static final double SEK_TO_USD_RATE = 10.87;
    private static final double SEK_TO_EUR_RATE = 11.32;

    private static final double FAHRENHEIT_MULTIPLIER = 9.0 / 5.0;
    private static final double CELSIUS_MULTIPLIER = 5.0 / 9.0;
    private static final double FAHRENHEIT_OFFSET = 32.0;

    private static final double CM_PER_METER = 100.0;
    private static final double METERS_PER_KILOMETER = 1000.0;

    public static void main(String[] args) {
        ConverterApp app = new ConverterApp();
        app.start();
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            boolean running = true;

            while (running) {
                displayMenu();

                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> handleCurrencyConverter(scanner);
                    case 2 -> handleTemperatureConverter(scanner);
                    case 3 -> handleLengthConverter(scanner);
                    case 4 -> running = false;
                    default -> System.out.println("Invalid option. Please choose 1-4.");
                }

                if (running) {
                    System.out.print("\nContinue? (yes/no): ");
                    String answer = scanner.next().trim();

                    running = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
                }
            }
        }

        System.out.println("Goodbye!");
    }

    private void displayMenu() {
        System.out.println("\n==================================");
        System.out.println("      LEXICON CONVERTER APP");
        System.out.println("==================================");
        System.out.println("1. Currency Converter");
        System.out.println("2. Temperature Converter");
        System.out.println("3. Length Converter");
        System.out.println("4. Exit");
        System.out.println("==================================");
    }


    private void handleCurrencyConverter(Scanner scanner) {
        System.out.println("\n--- Currency Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. SEK to USD");
        System.out.println("  2. SEK to EUR");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter amount in SEK: ");
            double sek = scanner.nextDouble();

            double usd = sekToUsd(sek);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f SEK = %.2f USD%n",
                    sek, usd
            );
        } else if (choice == 2) {
            System.out.print("Enter amount in SEK: ");
            double sek = scanner.nextDouble();

            double eur = sekToEur(sek);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f SEK = %.2f EUR%n",
                    sek, eur
            );
        } else {
            System.out.println("Invalid currency conversion option.");
        }
    }

    private void handleTemperatureConverter(Scanner scanner) {
        System.out.println("\n--- Temperature Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Celsius to Fahrenheit");
        System.out.println("  2. Fahrenheit to Celsius");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = scanner.nextDouble();

            double fahrenheit = celsiusToFahrenheit(celsius);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f C = %.2f F%n",
                    celsius, fahrenheit
            );
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();

            double celsius = fahrenheitToCelsius(fahrenheit);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f F = %.2f C%n",
                    fahrenheit, celsius
            );
        } else {
            System.out.println("Invalid temperature conversion option.");
        }
    }

    private void handleLengthConverter(Scanner scanner) {
        System.out.println("\n--- Length Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Centimeters to Meters");
        System.out.println("  2. Meters to Kilometers");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter length in centimeters: ");
            double centimeters = scanner.nextDouble();

            double meters = centimetersToMeters(centimeters);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f cm = %.2f m%n",
                    centimeters, meters
            );
        } else if (choice == 2) {
            System.out.print("Enter length in meters: ");
            double meters = scanner.nextDouble();

            double kilometers = metersToKilometers(meters);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f m = %.2f km%n",
                    meters, kilometers
            );
        } else {
            System.out.println("Invalid length conversion option.");
        }
    }

    private double sekToUsd(double sek) {
        return sek / SEK_TO_USD_RATE;
    }

    private double sekToEur(double sek) {
        return sek / SEK_TO_EUR_RATE;
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * FAHRENHEIT_MULTIPLIER
                + FAHRENHEIT_OFFSET;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_OFFSET)
                * CELSIUS_MULTIPLIER;
    }

    private double centimetersToMeters(double centimeters) {
        return centimeters / CM_PER_METER;
    }

    private double metersToKilometers(double meters) {
        return meters / METERS_PER_KILOMETER;
    }

}