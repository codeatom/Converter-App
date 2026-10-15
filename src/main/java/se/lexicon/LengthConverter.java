package main.java.se.lexicon;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LengthConverter {

    private static final double CM_PER_METER = 100.0;
    private static final double METERS_PER_KILOMETER = 1000.0;
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String convert(Scanner scanner) {
        System.out.println("\n--- Length Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Centimeters to Meters");
        System.out.println("  2. Meters to Kilometers");
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
            System.out.print("Enter length in centimeters: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric amount.");
                scanner.next();
            }

            double centimeters = scanner.nextDouble();
            double meters = centimetersToMeters(centimeters);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f cm = %.2f m%n",
                    centimeters, meters
            );

            System.out.println(
                    "Converted at: "
                            + LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

            return String.format(
                    Locale.US,
                    "%.2f cm = %.2f m  | Converted at: %s",
                    centimeters, meters, LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );

        } else {
            System.out.print("Enter length in meters: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric amount.");
                scanner.next();
            }

            double meters = scanner.nextDouble();
            double kilometers = metersToKilometers(meters);

            System.out.printf(
                    Locale.US,
                    "Result: %.2f m = %.2f km%n",
                    meters, kilometers
            );

            return String.format(
                    Locale.US,
                    "%.2f m = %.2f km  | Converted at: %s",
                    meters, kilometers, LocalDateTime.now().format(TIMESTAMP_FORMATTER)
            );
        }
    }

    private double centimetersToMeters(double centimeters) {
        return centimeters / CM_PER_METER;
    }

    private double metersToKilometers(double meters) {
        return meters / METERS_PER_KILOMETER;
    }
}