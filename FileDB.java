import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDB {
    private final String _path;
    public FileDB(String path) {
        _path = path;
    }

    public void save(String data) {
        if (!_path.endsWith(".txt")) return;

        try (FileWriter myWriter = new FileWriter(_path)) {
            myWriter.write(data);
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public ArrayList<String> load() {
        if (!_path.endsWith(".txt")) return null;

        File db = new File(_path);
        if (!db.exists()) {
            try {
                db.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create file: " + _path);
                return null;
            }
        }
        
        ArrayList<String> data = new ArrayList<>();

        try (Scanner reader = new Scanner(db)) {
            while (reader.hasNextLine()) {
                String item = reader.nextLine();
                data.add(item);
            }
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("File not found !!!");
            return null;
        }
    }
}