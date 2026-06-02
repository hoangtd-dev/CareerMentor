import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // System.out.println(triggerFeastSolution(15, 3, 2));
        // int[] result = removeDuplicate(new int[] { 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 6 });
        // for (int item : result) {
        //     System.out.println(item);
        // }

        // int[] result = moveZeroToEnds(new int[] { 0, 1, 0, 3, 4, 0, 5, 0, 6 });
        // for (int item : result) {
        //     System.out.println(item);
        // }
    }

    public static int triggerFeastSolution(int n, int c, int m) {
        int bars = n/c;
        int wrappers = bars;

        while (wrappers >= m) {
            int newBars = wrappers / m;
            bars += newBars;
            wrappers = (wrappers % m) + newBars;
        }

        return bars;
    }

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
}
