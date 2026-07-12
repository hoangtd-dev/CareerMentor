class FindMaxMinNumber {
	public static void main(String[] args) {
		findMaxMinNumber(new int[] { 3, 4, 5 });
	}

	public static void findMaxMinNumber(int[] nums) {
		if (nums.length == 0) {
			System.out.println("Empty list");
			return;
		}

		int max = nums[0], min = nums[0], total = nums[0];

		if (nums.length == 1) {
			System.out.println("Max: " + max + " - Min: " + min + " - Average: " + nums[0]);
			return;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];

			total += nums[i];
		}

		System.out.printf("Max: %d - Min: %d - Average: %.2f", max, min, (double) total / nums.length);
	}
}
