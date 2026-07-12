class GetDistanceOfAdjacentValues {
	public static void main(String[] args) {
		System.out.println(getDistanceOfAdjacentValues(new int[] { 1, 4, 7, 3, 3, 5 }));
	}

	// O(n + nlogn + n)
	public static int getDistanceOfAdjacentValues(int[] arr) {
		HashMap<Integer, Integer[]> map = new HashMap<>();

		// O(n)
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				Integer[] indexes = map.get(arr[i]);
				indexes[0] = Math.min(indexes[0], i);
				indexes[1] = Math.max(indexes[1], i);
				map.put(arr[i], indexes);
				continue;
			}

			map.put(arr[i], new Integer[] { i, i });
		}

		// O(nlogn)
		Arrays.sort(arr);

		int largestDistance = -1;
		// O(n)
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1])
				continue;

			Integer[] firstIndexes = map.get(arr[i]);
			Integer[] secondIndexes = map.get(arr[i + 1]);

			int maxDistanceWithFirstNum = Math.max(Math.abs(firstIndexes[0] - secondIndexes[0]),
					Math.abs(firstIndexes[0] - secondIndexes[1]));
			int maxDistanceWithSecondNum = Math.max(Math.abs(firstIndexes[1] - secondIndexes[0]),
					Math.abs(firstIndexes[1] - secondIndexes[1]));

			largestDistance = Math.max(Math.max(maxDistanceWithFirstNum, maxDistanceWithSecondNum), largestDistance);
		}

		return largestDistance;
	}
}
