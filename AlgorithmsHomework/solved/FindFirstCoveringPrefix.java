class FindFirstCoveringPrefix {
	public static void main(String[] args) {
		System.out.println(findFirstCoveringPrefix(new int[] { 1, 2, 1, 1, 1, 1 }));
	}

	public static int findFirstCoveringPrefix(int[] nums) {
		int last = nums.length - 1;
		int first = 0;

		while (last >= 0) {
			if (first == last)
				return last;

			if (nums[first] != nums[last]) {
				first++;
			} else {
				first = 0;
				last--;
			}
		}

		return last;
	}
}
