package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScannerUtils {
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

    public ScannerUtils() {
    }

    public int inputNumber(String placeholder) {
        while (true) {
            try {
                System.out.print(placeholder);
                return scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Input should be number !!!!");
            }
        }
    }

    public String inputString(String placeholder) {
        try {
            System.out.print(placeholder);
            return scanner.next();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Input should be String !!!!");
            return null;
        }
    }

    public LocalDate inputDate(String placeholder) {
        while (true) {
            try {
                System.out.print(placeholder);
                String dob = scanner.next();
                return LocalDate.parse(dob, formatter);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Please follow the date format: YYYY-MM-dd !!!");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
