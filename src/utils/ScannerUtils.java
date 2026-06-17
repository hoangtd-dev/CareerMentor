package utils;

import java.time.LocalDate;
import java.util.Scanner;

import constants.Constants;

public class ScannerUtils {
    public final static Scanner scanner = new Scanner(System.in);

    public static int inputNumber(String placeholder) {
        while (true) {
            try {
                System.out.print(placeholder);
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Input should be number !!!!");
            }
        }
    }

    public static String inputString(String placeholder) {
        try {
            System.out.print(placeholder);
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Input should be String !!!!");
            return null;
        }
    }

    public static LocalDate inputDate(String placeholder) {
        while (true) {
            try {
                System.out.print(placeholder);
                String dob = scanner.nextLine();
                return LocalDate.parse(dob, Constants.DATE_FORMATTER);
            } catch (Exception e) {
                System.out.println("Please follow the date format: YYYY-MM-dd !!!");
            }
        }
    }

    public static void close() {
        scanner.close();
    }
}
