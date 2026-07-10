public class BE10LinkedList {
	private int length = 0;
	public BE10LinkedListItem head;

	// O(n)
	// n = length of linkedlist
	public BE10LinkedListItem get(int index) {
		if (index < 0 || index >= length)
			return null;

		int position = 1;
		BE10LinkedListItem result = head;
		while (position <= index) {
			result = result.next;
			position++;
		}

		return result;
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return head == null;
	}

	// O(n)
	// n = length of linkedlist
	public void addAtEnd(BE10LinkedListItem item) {
		item.next = null;
		if (head == null) {
			head = item;
			length++;
			return;
		}

		BE10LinkedListItem lastItem = get(length - 1);

		lastItem.next = item;
		length++;
	}

	// O(n)
	// n = length of linkedlist
	public void addAtIndex(BE10LinkedListItem item, int index) {
		if (index < 0)
			return;

		if (index == 0) {
			item.next = head;
			head = item;
			length++;
			return;
		}

		if (length == 0 || index >= length) {
			addAtEnd(item);
			return;
		}

		BE10LinkedListItem prevItem = get(index - 1);

		item.next = prevItem.next;
		prevItem.next = item;
		length++;
	}

	// O(n)
	// n = length of linkedlist
	public void remove(int index) {
		if (head == null || index < 0 || index >= length)
			return;

		if (index == 0) {
			head = head.next;
			length--;
			return;
		}

		BE10LinkedListItem prev = get(index - 1);
		prev.next = prev.next.next;
		length--;
	}

	public void clear() {
		length = 0;
		head = null;
	}

	// O(1)
	public BE10LinkedListItem poll() {
		if (size() == 0)
			return null;

		BE10LinkedListItem deletedItem = head;
		head = head.next;
		length--;

		return deletedItem;
	}

	public void displayAllItems() {
		if (length == 0)
			return;

		BE10LinkedListItem current = head;
		System.out.println(String.format("Value: %s - Next: %s", current.value, current.next));
		while (current.next != null) {
			current = current.next;
			System.out.println(String.format("Value: %s - Next: %s", current.value, current.next));
		}
	}
}