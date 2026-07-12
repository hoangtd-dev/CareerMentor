class GetBinaryGap {
	public static void main(String[] args) {
		System.out.println(getBinaryGap(9));
		System.out.println(getBinaryGap(529));
		System.out.println(getBinaryGap(20));
		System.out.println(getBinaryGap(15));
		System.out.println(getBinaryGap(32));
	}

	public static int getBinaryGap(int number) {
		String binaryStr = Integer.toBinaryString(number);
		String[] chars = binaryStr.split("");
		List<Integer> indexes = new ArrayList<>();

		for (int i = 0; i < chars.length; i++) {
			if (chars[i].equals("1"))
				indexes.add(i);
		}

		int result = 0;
		if (indexes.size() == chars.length || indexes.size() == 1)
			return result;

		for (int i = 0; i < indexes.size() - 1; i++) {
			int newGap = indexes.get(i + 1) - indexes.get(i) - 1;
			if (newGap > result)
				result = newGap;
		}
		return result;

		// int result = 0;
		// int firstPointer = 0;
		// int secondPointer = 0;
		//
		// while (secondPointer < chars.length) {
		// if (chars[secondPointer].equals("0")) {
		// secondPointer++;
		// } else if (chars[firstPointer].equals("0")) {
		// firstPointer = secondPointer;
		// } else if (firstPointer == secondPointer) {
		// secondPointer++;
		// } else {
		// int newGap = (secondPointer - firstPointer - 1);
		// if (newGap > result) result = newGap;
		// firstPointer++;
		// secondPointer++;
		// }
		// }

		// return result;
	}
}
