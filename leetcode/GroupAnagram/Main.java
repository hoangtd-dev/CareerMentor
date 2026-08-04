import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // requirement: https://leetcode.com/problems/group-anagrams/
    public static void main(String[] args) {
        var result = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        for (List<String> item : result) {
            for (String item1 : item) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String item : strs) {
            int[] checked = new int[26];

            for (int i = 0; i < item.length(); i++) {
                checked[item.charAt(i) - 97] += 1;
            }

            String key = "";
            for (int i = 0; i < 26; i++) {
                key += checked[i] + ",";
            }

            System.out.println(item + " - " + key);
            if (!map.containsKey(key)) {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(item);
                map.put(key, arr);
            } else {
                map.get(key).add(item);
            }
        }

        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            result.add(item.getValue());
        }

        return result;
    }
}