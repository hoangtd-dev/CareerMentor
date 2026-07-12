class TotalEvenNumber {
	public static void main(String[] args) {
		System.out.println(calculate(new long[] { 4L, 1L, 2L, 3L }));
		System.out.println(calculate(new long[] { 1L, 2L, 3L, 3L, 2L, 1L, 5L }));
		System.out.println(calculate(new long[] { 1000000000L, 1L, 2L, 2L, 1000000000L, 1L, 1000000000L }));
		System.out.println(calculate(new long[] { 4L, 4L, 4L, 5L }));
	}

	public static long calculate(long[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		List<Long> arrangedNums = new ArrayList<>();

		arrangedNums.add(nums[0]);
		int index = 1;

		while (index < nums.length) {
			if ((arrangedNums.size() % 2 == 1 && nums[index] > arrangedNums.getLast()) ||
					(arrangedNums.size() % 2 == 0 && nums[index] < arrangedNums.getLast())) {
				arrangedNums.removeLast();
			}

			if (arrangedNums.isEmpty() || nums[index] != arrangedNums.getLast()) {
				arrangedNums.add(nums[index]);
			}

			index++;
		}
		System.out.println(arrangedNums);

		long result = arrangedNums.getFirst();
		for (int i = 1; i < arrangedNums.size(); i++) {
			if (i % 2 == 0) {
				result += arrangedNums.get(i);
			} else {
				result -= arrangedNums.get(i);
			}
		}

		return result;
	}
}
