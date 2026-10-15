package main.java.se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConverterApp {

    private final List<String> conversionHistory = new ArrayList<>();

    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    private final TemperatureConverter temperatureConverter = new TemperatureConverter();

    private final LengthConverter lengthConverter = new LengthConverter();


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
                    System.out.println(
                            "Invalid input. Please enter a number between 1 and 4."
                    );
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> handleCurrencyConverter(scanner);
                    case 2 -> handleTemperatureConverter(scanner);
                    case 3 -> handleLengthConverter(scanner);
                    case 4 -> running = false;
                    default -> {
                        System.out.println("Invalid input. Please enter a number between 1 and 4.");
                        scanner.next();
                    continue;}
                }

                if (running) {
                    String answer;

                    while (true) {
                        System.out.print("\nContinue? (yes/no): ");
                        answer = scanner.next().trim();

                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            break;
                        } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                            running = false;
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter (yes/no) ");
                        }
                    }
                }
            }
        }

        displayConversionHistory();
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
        String result = currencyConverter.convert(scanner);

        if (result != null) {
            conversionHistory.add(result);
        }
    }

    private void handleTemperatureConverter(Scanner scanner) {
        String result = temperatureConverter.convert(scanner);

        if (result != null) {
            conversionHistory.add(result);
        }
    }

    private void handleLengthConverter(Scanner scanner) {
        String result = lengthConverter.convert(scanner);

        if (result != null) {
            conversionHistory.add(result);
        }
    }

    private void displayConversionHistory() {
        System.out.println("\n=== Conversion History ===");

        if (conversionHistory.isEmpty()) {
            System.out.println("No conversions performed.");
        } else {
            for (int i = 0; i < conversionHistory.size(); i++) {
                System.out.printf(
                        "%d.  %s%n",
                        i + 1,
                        conversionHistory.get(i)
                );
            }
        }

        System.out.println("==========================");
        System.out.println("Total conversions: " + conversionHistory.size());
    }
}