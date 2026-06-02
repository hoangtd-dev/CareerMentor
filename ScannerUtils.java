import java.util.Scanner;

public class ScannerUtils {
    public static int InputNumber(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Input should be number !!!!");
            return -1;
        }
    }

    public static String InputString(Scanner scanner) {
        try {
            return scanner.next();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Input should be String !!!!");
            return null;
        }
    }
}
