import java.util.HashMap;
import java.util.Map;

public class Main {
    // requirement: https://leetcode.com/problems/two-sum/
    public static void main(String[] args) {
        int[] result = twoSum(new int[] { 3, 3 }, 6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // O(n)
    public static int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int matchingNumber = target - nums[i];
            if (map.containsKey(matchingNumber) && map.get(matchingNumber) != i) {
                return new int[] { i, map.get(matchingNumber) };
            }
        }

        return null;
    }
}