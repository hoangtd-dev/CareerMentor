public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (var item : map.entrySet()) {
            maxHeap.add(new int[] { item.getKey(), item.getValue() });
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll()[0];
        }

        return result;
    }
}