import java.util.Arrays;

class FindTriangularTriplet {
	public static void main(String[] args) {
		System.out.println(findTriangularTriplet(new int[] { 10, 5, 1, 7, 8 }));
	}

	public static int findTriangularTriplet(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] + nums[i + 1] > nums[i + 2])
				return 1;
		}

		return 0;
	}
}
