import java.util.Scanner;

public class ScannerUtils {
    Scanner scanner = new Scanner(System.in);

    public ScannerUtils() {}

    public int InputNumber() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Input should be number !!!!");
            return -1;
        }
    }

    public String InputString() {
        try {
            return scanner.next();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Input should be String !!!!");
            return null;
        }
    }

    public void close() {
        scanner.close();
    }
}
