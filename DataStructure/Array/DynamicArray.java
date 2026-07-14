public class DynamicArray {
	private int[] arr = new int[10];
	private int nextIndex = 0;

	public int get(int index) {
		// throw error if index > nextIndex or index < 0
		return arr[index];
	}

	public int length() {
		return nextIndex;
	}

	// O(n)
	public void add(int value) {
		if (nextIndex == arr.length - 1) {
			int[] newArr = new int[arr.length * 2];

			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}

			arr = newArr;
		}

		arr[nextIndex++] = value;
	}

	// O(n)
	public void removeAtIndex(int index) {
		// throw error if index > nextIndex or index < 0
		int[] newArr = new int[arr.length];
		nextIndex--;

		int oldArrIndex = 0;
		for (int i = 0; i < nextIndex; i++) {
			if (oldArrIndex == index)
				oldArrIndex++;

			newArr[i] = arr[oldArrIndex++];
		}

		arr = newArr;
	}
}
