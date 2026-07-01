import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // System.out.println(triggerFeastSolution_2(15, 3, 2)); // 9
        // System.out.println(triggerFeastSolution_2(20, 4, 2)); // 9
        // System.out.println(triggerFeastSolution_2(12, 2, 3)); // 8
        // System.out.println(triggerFeastSolution_2(9, 3, 3)); // 4
        // System.out.println(triggerFeastSolution_2(100, 5, 4)); // 26
        // System.out.println(triggerFeastSolution_2(7, 1, 2)); // 13
        // System.out.println(triggerFeastSolution_2(1, 1, 2)); // 1
        // System.out.println(triggerFeastSolution_2(50, 10, 5)); // 6
        // System.out.println(triggerFeastSolution_2(30, 6, 3)); // 7
        // System.out.println(triggerFeastSolution_2(1000, 2, 3)); // 749

        // int[] result = removeDuplicate(new int[] { 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 6
        // });
        // for (int item : result) {
        // System.out.println(item);
        // }

        // int[] result = moveZeroToEnds(new int[] { 0, 1, 0, 3, 4, 0, 5, 0, 6 });
        // for (int item : result) {
        // System.out.println(item);
        // }

        // System.out.println(wrapText("SMS messages are really short", 12));
        // 3

        System.out.println(wrapText("This is a test", 4));
        // 3
    }

    // O(n) => m can reduce the loop time but it is still a linear
    public static int triggerFeastSolution(int n, int c, int m) {
        int bars = n / c;
        int wrappers = bars;

        while (wrappers >= m) {
            int newBars = wrappers / m;
            bars += newBars;
            wrappers = (wrappers % m) + newBars;
        }

        return bars;
    }

    // O(n) + need more space
    public static int[] removeDuplicate(int[] nums) {
        int size = 1;
        int currentNumber = nums[0];

        for (int num : nums) {
            if (currentNumber != num) {
                size++;
                currentNumber = num;
            }
        }

        int[] newArr = new int[size];

        currentNumber = nums[0];
        newArr[0] = currentNumber;
        int index = 1;

        for (int num : nums) {
            if (currentNumber != num) {
                newArr[index++] = num;
                currentNumber = num;
            }
        }

        return newArr;
    }

    // O(n)
    public static int[] moveZeroToEnds(int[] nums) {
        int[] newArr = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                newArr[index++] = num;
            }
        }

        return newArr;
    }

    // O(n)
    public static int wrapText(String s, int k) {
        String[] sanitizedStrings = s.trim().split(" ");
        int count = sanitizedStrings[0].length();
        int result = 0;

        for (int i = 0; i < sanitizedStrings.length; i++) {
            if (sanitizedStrings[i].length() > k)
                return -1;
        }

        for (int i = 1; i < sanitizedStrings.length; i++) {
            int tmpCount = count + 1 + sanitizedStrings[i].length();
            if (tmpCount > k) {
                result++;
                count = sanitizedStrings[i].length();
            } else if (tmpCount == k) {
                result++;
                count = -1;
            } else {
                count = tmpCount;
            }
        }

        if (count > 0)
            result++;

        return result;
    }
}
