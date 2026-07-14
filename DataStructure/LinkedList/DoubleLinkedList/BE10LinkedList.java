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
		item.prev = null;
		item.next = null;
		if (head == null) {
			head = item;
			tail = item;
			length++;
			return;
		}

		item.prev = tail;
		tail.next = item;
		tail = item;
		length++;
	}

	// O(n)
	public void addAtIndex(BE10LinkedListItem item, int index) {
		if (head == null) {
			head = item;
			tail = item;
			length++;
			return;
		}

		if (index == 0) {
			head.prev = item;
			item.prev = null;
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

		item.prev = prevItem;
		item.next = prevItem.next;
		prevItem.next.prev = item;
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

		if (index == length - 1) {
			removeAtLast();
			return;
		}

		BE10LinkedListItem prev = get(index - 1);

		prev.next = prev.next.next;
		prev.next.prev = prev;
		length--;
	}

	// O(1)
	public void removeAtLast() {
		if (size() == 1) {
			head = null;
			tail = null;
			length--;
			return;
		}

		tail = tail.prev;
		tail.next = null;

		length--;
	}

	public void clear() {
		length = 0;
		head = null;
		tail = null;
	}

	// O(1)
	public BE10LinkedListItem poll() {
		if (size() == 0)
			return null;

		BE10LinkedListItem deletedItem = head;

		if (size() == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}

		length--;
		return deletedItem;
	}

	public void displayAllItems() {
		if (length == 0)
			return;

		BE10LinkedListItem current = head;
		System.out.println(String.format("Id: %s - Value: %s - Next: %s - Pre: %s", current.toString(), current.value,
				current.next, current.prev));
		while (current.next != null) {
			current = current.next;
			System.out.println(String.format("Id: %s - Value: %s - Next: %s - Pre: %s", current.toString(), current.value,
					current.next, current.prev));
		}
	}
}