public class Main {
    // requirement:
    // https://leetcode.com/problems/concatenation-of-array/description/
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }

        return result;
    }
}