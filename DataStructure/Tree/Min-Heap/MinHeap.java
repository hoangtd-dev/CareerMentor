public class MinHeap {
	public int[] heap;
	public int size;

	public MinHeap(int capacity) {
		heap = new int[capacity];
		size = 0;
	}

	public void add(int value) {
		heap[size] = value;
		int i = size;

		while (i > 0) {
			int parent = (i - 1) / 2;

			if (heap[i] >= heap[parent])
				break;

			int tmp = heap[i];
			heap[i] = heap[parent];
			heap[parent] = tmp;
			i = parent;
		}

		size++;
	}

	public int removeMin() {
		int min = heap[0];
		heap[0] = heap[size - 1];
		size--;

		int i = 0;
		while (true) {
			int smallest = i;
			int left = 2 * i + 1;
			int right = 2 * i + 2;

			if (left < size && heap[left] < heap[smallest])
				smallest = left;
			if (right < size && heap[right] < heap[smallest])
				smallest = right;

			if (smallest == i)
				break;

			int tmp = heap[i];
			heap[i] = heap[smallest];
			heap[smallest] = tmp;
			i = smallest;
		}

		return min;
	}
}