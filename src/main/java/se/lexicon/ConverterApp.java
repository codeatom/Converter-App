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

    }

    private void handleTemperatureConverter(Scanner scanner) {

    }

    private void handleLengthConverter(Scanner scanner) {

    }

}