class Solution {
	// requirement: https://leetcode.com/problems/reverse-integer/
	public int reverse(int x) {
		if (x == 0)
			return 0;
		int tmp = x;
		boolean isNegative = false;
		String resultStr = "";

		if (x < 0) {
			isNegative = true;
			tmp *= -1;
		}

		while (tmp > 0) {
			resultStr += tmp % 10;
			tmp /= 10;
		}

		try {
			int result = Integer.parseInt(resultStr);

			if (isNegative) {
				result *= -1;
			}

			return result;
		} catch (Exception e) {
			return 0;
		}
	}
}