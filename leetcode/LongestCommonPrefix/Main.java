public class Main {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }

    public static String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (String str : strs) {
            if (minLength > str.length())
                minLength = str.length();
        }

        for (int i = 0; i < minLength; i++) {
            char currCharacter = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currCharacter)
                    return result;
            }

            result += currCharacter;
        }

        return result;
    }
}