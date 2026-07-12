class GetAdjacentValues {
	public static void main(String[] args) {
		System.out.println(getAdjacentValues(new int[] { 0, 3, 3, 7, 5, 3, 11, 1 }));
	}

	// O(nlogn + n) = O(nlogn)
	public static int getAdjacentValues(int[] arr) {
		// O(nlogn)
		Arrays.sort(arr);

		int first = 0;
		int second = 1;

		int count = 0;

		// O(n)
		while (first < arr.length - 1) {
			if (second == arr.length
					|| (first != second - 1 && arr[second - 1] != arr[first] && arr[second - 1] != arr[second])) {
				first++;
				second = first + 1;
				continue;
			}

			count++;
			second++;

			if (count > 100000000)
				return -1;
		}

		return count;
	}
}
