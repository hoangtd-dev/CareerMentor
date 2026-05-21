void main() {
//    System.out.println(getBinaryGap(9));
//    System.out.println(getBinaryGap(529));
//    System.out.println(getBinaryGap(20));
//    System.out.println(getBinaryGap(15));
//    System.out.println(getBinaryGap(32));


    System.out.println(calculate(new long[]{ 4L,1L,2L,3L}));
    System.out.println(calculate(new long[]{ 1L,2L,3L,3L,2L,1L,5L}));
    System.out.println(calculate(new long[]{ 1000000000L, 1L,2L,2L,1000000000L, 1L, 1000000000L}));
    System.out.println(calculate(new long[]{ 4L, 4L, 4L, 5L }));
}

public int getBinaryGap(int number) {
    String binaryStr = Integer.toBinaryString(number);
    String[] chars = binaryStr.split("");
    List<Integer> indexes = new ArrayList<>();

    for (int i = 0; i < chars.length; i++) {
        if (chars[i].equals("1")) indexes.add(i);
    }

    int result = 0;
    if (indexes.size() == chars.length || indexes.size() == 1) return result;

    for (int i = 0; i < indexes.size() - 1; i++) {
        int newGap = indexes.get(i+1) - indexes.get(i) - 1;
        if (newGap > result) result = newGap;
    }
    return result;

//    int result = 0;
//    int firstPointer = 0;
//    int secondPointer = 0;
//
//    while (secondPointer < chars.length) {
//        if (chars[secondPointer].equals("0")) {
//            secondPointer++;
//        } else if (chars[firstPointer].equals("0")) {
//            firstPointer = secondPointer;
//        } else if (firstPointer == secondPointer) {
//            secondPointer++;
//        } else {
//            int newGap = (secondPointer - firstPointer - 1);
//            if (newGap > result) result = newGap;
//            firstPointer++;
//            secondPointer++;
//        }
//    }

//    return result;
}

public long calculate(long[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

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