import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // int[] arr = { 3, 4, 3, 2, 3, -1, 3, 3 };
        // System.out.println(findDominator(arr));
        // int[] arr2 = { 0, 1, 3, -2, 0, 1, 0, -3, 2, 3 };
        // System.out.println(getMaxPitDepth(arr2));
    }

    // O(n) - Space(n) using hashmap
    public static int findDominator(int[] arr) {
        int length = arr.length;
        if (length == 0)
            return -1;

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (count.get(arr[i]) > length / 2) {
                return i;
            }
        }

        return -1;
    }

    // O(n^2)
    public static int getMaxPitDepth(int[] arr) {
        int length = arr.length;
        int deepest = -1;

        for (int mid = 1; mid < length - 1; mid++) {
            if (!(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]))
                continue;

            int left = mid - 1;
            while (left > 0 && arr[left - 1] > arr[left]) {
                left--;
            }

            int right = mid + 1;
            while (right < length - 1 && arr[right + 1] > arr[right]) {
                right++;
            }

            int leftHeight = arr[left] - arr[mid];
            int rightHeight = arr[right] - arr[mid];
            int currentDepth = Math.min(leftHeight, rightHeight);

            deepest = Math.max(deepest, currentDepth);
        }

        return deepest;
    }
}