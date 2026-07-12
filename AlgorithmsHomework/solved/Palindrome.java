class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(new int[] { 1, 2, 2, 1 }));
	}

	public static boolean isPalindrome(int[] nums) {
		if (nums.length < 3)
			return false;

		int firstIndex = 0, lastIndex = nums.length - 1;

		while (firstIndex < lastIndex) {
			if (nums[firstIndex] != nums[lastIndex])
				return false;

			firstIndex++;
			lastIndex--;
		}
		return true;
	}
}
