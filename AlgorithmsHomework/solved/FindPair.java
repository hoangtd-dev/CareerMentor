class FindPair {
	public static void main(String[] args) {
		System.out.println(findPair(new int[] { 2, 1, 5, -6, 9 }));
	}

	public static int findPair(int[] nums) {
		int evenCount = 0;
		int oddCount = 0;

		for (int num : nums) {
			if (num > 1000000000 || num < -1000000000)
				return -1;

			if (num % 2 == 0)
				evenCount++;
			else
				oddCount++;
		}

		return (evenCount * (evenCount - 1) / 2) + (oddCount * (oddCount - 1) / 2);
	}
}
