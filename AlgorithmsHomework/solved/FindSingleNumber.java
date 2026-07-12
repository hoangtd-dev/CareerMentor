class FindSingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 5, 4, 3, 3, 4, 1, 1, 2, 2 }));
	}

	public static int singleNumber(int[] nums) {
		int result = 0;

		for (int num : nums) {
			result ^= num;
		}

		return result;
	}
}
