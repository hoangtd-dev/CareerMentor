class PrimeNumber {
	public static void main(String[] args) {
		for (int i = -1; i < 100; i++) {
			if (isPrimeNumber(i))
				System.out.println("i: " + i);
		}
	}

	public static boolean isPrimeNumber(int number) {
		if (number == 1 || number == 2)
			return true;
		if (number < 1 || number % 2 == 0)
			return false;

		int halfNumber = (int) Math.sqrt(number);
		int startNumber = 3;
		while (startNumber <= halfNumber) {
			if (number % startNumber == 0)
				return false;

			startNumber++;
		}

		return true;
	}
}
