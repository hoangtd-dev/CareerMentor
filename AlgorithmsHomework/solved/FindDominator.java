import java.util.HashMap;

class FindDominator {
	public static void main(String[] args) {
		int[] arr = { 6, 4, 3, 2, 3, 3, 3, 3 };
		System.out.println(findDominator(arr));
	}

	// O(n) - Space(n) using hashmap
	public static int findDominator(int[] arr) {
		int length = arr.length;
		if (length == 0)
			return -1;

		// Space (count)
		HashMap<Integer, Integer> count = new HashMap<>();

		// O(n)
		for (int num : arr) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		// O(n)
		for (int i = 0; i < length; i++) {
			if (count.get(arr[i]) > length / 2) {
				return i;
			}
		}

		return -1;
	}
}
