class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       int negativeIndex = 0;
       List<List<Integer>> result = new ArrayList<>();

       while (nums[negativeIndex] <= 0 && negativeIndex < nums.length - 1) {
        if (negativeIndex > 0 && nums[negativeIndex] == nums[negativeIndex - 1]) {
          negativeIndex++;
          continue;
        }

        int left = negativeIndex + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[negativeIndex] + nums[left] + nums[right];
          if (sum == 0) {
            result.add(new ArrayList<Integer>(List.of(nums[negativeIndex], nums[left], nums[right])));
            left++;
            right--;

            while (nums[left - 1] == nums[left] && left < right) left++;
          } else if (sum < 0) {
            left++;
          } else {
            right--;
          }
          
        }
        negativeIndex++;
       }

       return result;
    }
}