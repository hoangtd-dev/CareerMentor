void main() {
//    findMaxMinNumber(new int[] {3, 4, 5});
//    System.out.println(isPalindrome(new int[] {1, 2, 2, 1}));
//    for (int i = -1; i < 100; i++) {
//        if (isPrimeNumber(i))
//            System.out.println("i: "+i);
//    }

//    System.out.println(singleNumber(new int[] { 5,4,3,3,4,1,1,2,2 }));
}

public void findMaxMinNumber(int[] nums) {
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
       if (nums[i] > max) max = nums[i];
       if (nums[i] < min) min = nums[i];

       total += nums[i];
   }

    System.out.printf("Max: %d - Min: %d - Average: %.2f", max, min, (double) total / nums.length);
}

public boolean isPalindrome(int[] nums) {
   if (nums.length < 3) return false;

   int firstIndex = 0, lastIndex = nums.length - 1;

   while (firstIndex < lastIndex) {
       if (nums[firstIndex] != nums[lastIndex]) return false;

       firstIndex++;
       lastIndex--;
   }
   return true;
}

public boolean isPrimeNumber(int number) {
    if (number == 1 || number == 2) return true;
    if (number < 1 || number % 2 == 0) return false;

    int halfNumber = (int) Math.sqrt(number);
    int startNumber = 3;
    while (startNumber <= halfNumber) {
        if (number % startNumber == 0) return false;

        startNumber++;
    }

    return true;
}

public int singleNumber(int[] nums) {
    int result = 0;

    for (int num : nums) {
        result ^= num;
    }

    return result;
}