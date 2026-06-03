import java.util.Scanner;

public class ScannerUtils {
    private final Scanner _scanner = new Scanner(System.in);

    public ScannerUtils() {}

    public int inputNumber() {
        try {
            return _scanner.nextInt();
        } catch (Exception e) {
            _scanner.nextLine();
            System.out.println("Input should be number !!!!");
            return -1;
        }
    }

    public String inputString() {
        try {
            return _scanner.next();
        } catch (Exception e) {
            _scanner.nextLine();
            System.out.println("Input should be String !!!!");
            return null;
        }
    }

    public void close() {
        _scanner.close();
    }
}
