import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String path = "new_transactions.csv";
        String splitBy = ",";
        readCsv(path, splitBy);
    }

    private static void readCsv(String path, String splitBy) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // skip header
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy);

                Transaction transaction = new Transaction();

                try {
                    transaction.setTransactionId(Integer.parseInt(values[0]));
                    transaction.setType(values[1]);
                    transaction.setAmount(Double.parseDouble(values[2]));

                } catch (NumberFormatException e) {
                    logError(line, "NumberFormatException: " + e.getMessage());
                    continue;
                } catch (Exception e) {
                    logError(line, "Exception: " + e.getMessage());
                    continue;
                }
                addToDB(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToDB(Transaction transaction) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("transactions.csv", true))) {
            pw.println(transaction.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logError(String line, String errorMsg) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("errors.csv", true))) {
            pw.println(String.format("%s,%s", line, errorMsg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}