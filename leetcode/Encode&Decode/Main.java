import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<String>();
        // arr.add("Hel#lo");
        // arr.add("Wor#ld");
        // arr.add("T#est");
        arr.add("");
        String encodeStr = encode(arr);
        System.out.println(encodeStr);

        var resultArr = decode(encodeStr);
        for (String item : resultArr) {
            System.out.println(item);
        }
    }

    public static String encode(List<String> strs) {
        String result = "";

        for (String str : strs) {
            if (str.length() == 0)
                continue;
            result += str.length() + "#" + str;
        }

        return result;
    }

    public static List<String> decode(String str) {
        var result = new ArrayList<String>();
        if (str.isEmpty()) {
            result.add("");
            return result;
        }

        String countStr = "";
        int index = 0;
        boolean readMode = false;

        while (index < str.length()) {
            char c = str.charAt(index);

            if (!readMode && c == '#') {
                readMode = true;
                index++;
                continue;
            }

            if (readMode) {
                int maxLength = Integer.parseInt(countStr) + index;
                String code = "";
                for (int i = index; i < maxLength; i++) {
                    code += str.charAt(i);
                    index++;
                }

                result.add(code);
                readMode = false;
                countStr = "";
                continue;
            }

            if (!readMode) {
                countStr += c;
                index++;
            }
        }

        return result;
    }
}