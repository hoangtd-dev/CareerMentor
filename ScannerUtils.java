import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScannerUtils {
    private final Scanner _scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

    public ScannerUtils() {}

    public int inputNumber() {
        while (true) {
            try {
                return _scanner.nextInt();
            } catch (Exception e) {
                _scanner.nextLine();
                System.out.println("Input should be number !!!!");
            }
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

    public LocalDate inputDate() {
        while (true) {
            try {
                String dob = _scanner.next();
                return LocalDate.parse(dob, formatter);
            } catch (Exception e) {
                _scanner.nextLine();
                System.out.println("Please follow the date format: YYYY-MM-dd !!!");
            }
        }
    }

    public void close() {
        _scanner.close();
    }
}
