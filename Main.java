void main() {
//    System.out.println(findFirstCoveringPrefix(new int[] {1,2,1,1,1,1}));
//    System.out.println(findTriangularTriplet(new int[] {10, 5, 1, 7, 8}));
//    System.out.println(findPair(new int[] {2, 1, 5, -6, 9}));
}

public int findFirstCoveringPrefix(int[] nums) {
    int last = nums.length - 1;
    int first = 0;

    while (last >= 0) {
        if (first == last) return last;

        if (nums[first] != nums[last]) {
            first++;
        } else {
            first = 0;
            last--;
        }
    }

    return last;
}


public int findTriangularTriplet(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
        if (nums[i] + nums[i+1] > nums[i+2]) return 1;
    }

    return 0;
}

public int findPair(int[] nums) {
    int evenCount = 0;
    int oddCount = 0;

    for (int num : nums) {
        if (num > 1000000000 || num < -1000000000) return -1;

        if (num % 2 == 0) evenCount++;
        else oddCount++;
    }

    return (evenCount * (evenCount - 1) / 2) + (oddCount * (oddCount - 1) / 2);
}