public class BE10LinkedList {
	private int length = 0;
	private BE10LinkedListItem head;
	private BE10LinkedListItem tail;

	public BE10LinkedListItem getHead() {
		return head;
	}

	public BE10LinkedListItem getTail() {
		return tail;
	}

	// O(n)
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

	// O(1)
	public void addAtEnd(BE10LinkedListItem item) {
		item.next = head;
		if (head == null) {
			head = item;
			tail = item;
			length++;
			return;
		}

		tail.next = item;
		tail = item;
		length++;
	}

	// O(n)
	public void addAtIndex(BE10LinkedListItem item, int index) {
		if (head == null) {
			item.next = head;
			head = item;
			tail = item;
			length++;
			return;
		}

		if (index == 0) {
			item.next = head;
			tail.next = item;
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
	public void remove(int index) {
		if (head == null || index < 0 || index >= length)
			return;

		if (index == 0) {
			poll();
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

		if (size() == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			tail.next = head;
		}

		length--;
		return head;
	}

	public void displayAllItems() {
		if (length == 0)
			return;

		int index = 0;
		BE10LinkedListItem current = head;
		System.out.println(String.format("Id: %s - Value: %s - Next: %s", current.toString(), current.value, current.next));
		while (index < length - 1) {
			current = current.next;
			System.out
					.println(String.format("Id: %s - Value: %s - Next: %s", current.toString(), current.value, current.next));
			index++;
		}
	}
}