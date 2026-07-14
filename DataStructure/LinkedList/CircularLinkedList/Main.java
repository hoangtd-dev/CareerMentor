public class Main {
    public static void main(String[] args) {
        BE10LinkedList list = new BE10LinkedList();
        BE10LinkedListItem item = new BE10LinkedListItem(10);
        BE10LinkedListItem item1 = new BE10LinkedListItem(20);
        BE10LinkedListItem item2 = new BE10LinkedListItem(30);
        BE10LinkedListItem item3 = new BE10LinkedListItem(40);
        BE10LinkedListItem item4 = new BE10LinkedListItem(50);
        BE10LinkedListItem item5 = new BE10LinkedListItem(60);

        list.addAtEnd(item);
        list.addAtEnd(item1);
        list.addAtEnd(item2);
        list.addAtEnd(item3);
        list.addAtEnd(item4);
        list.addAtEnd(item5);

        System.out.println("---INITIAL VALUE---");
        System.out.println("size: " + list.size());
        list.displayAllItems();

        System.out.println("---CHECK CIRCULAR LINK---");
        BE10LinkedListItem head = list.get(0);
        BE10LinkedListItem tail = list.get(list.size() - 1);
        System.out.println("head = " + head.value);
        System.out.println("tail = " + tail.value);
        System.out.println("tail.next = " + tail.next.value); // phải == head.value
        System.out.println("tail.next==head: " + (tail.next == head)); // phải true

        System.out.println("---GET BY INDEX---");
        System.out.println(list.get(0).value); // 10
        System.out.println(list.get(1).value); // 20
        System.out.println(list.get(2).value); // 30
        System.out.println(list.get(3).value); // 40
        System.out.println(list.get(4).value); // 50
        System.out.println(list.get(5).value); // 60

        System.out.println("---REMOVE BY INDEX---");
        list.remove(2); // xoá 30
        list.remove(3); // xoá 50 (index dịch sau khi xoá 30)

        System.out.println("size: " + list.size());
        list.displayAllItems(); // 10 -> 20 -> 40 -> 60

        // kiểm tra vòng tròn còn nguyên sau khi xoá giữa
        System.out.println("---CHECK CIRCULAR AFTER REMOVE BY INDEX---");
        head = list.get(0);
        tail = list.get(list.size() - 1);
        System.out.println("tail = " + tail.value);
        System.out.println("tail.next = " + tail.next.value);
        System.out.println("tail.next==head: " + (tail.next == head)); // phải true

        System.out.println("---REMOVE FIRST ITEM---");
        list.poll(); // xoá 10

        System.out.println("size: " + list.size());
        list.displayAllItems(); // 20 -> 40 -> 60

        // kiểm tra vòng tròn: tail.next phải trỏ về head mới (20)
        System.out.println("---CHECK CIRCULAR AFTER POLL---");
        head = list.get(0);
        tail = list.get(list.size() - 1);
        System.out.println("new head = " + head.value); // 20
        System.out.println("tail = " + tail.value); // 60
        System.out.println("tail.next = " + tail.next.value);
        System.out.println("tail.next==head: " + (tail.next == head)); // phải true

        System.out.println("---ADD BY INDEX---");
        BE10LinkedListItem item6 = new BE10LinkedListItem(-1);
        BE10LinkedListItem item7 = new BE10LinkedListItem(100);
        list.addAtIndex(item6, 0); // chèn đầu → -1 -> 20 -> 40 -> 60
        list.addAtIndex(item7, 2); // chèn giữa → -1 -> 20 -> 100 -> 40 -> 60

        System.out.println("size: " + list.size());
        list.displayAllItems();

        // kiểm tra vòng tròn sau khi chèn đầu và chèn giữa
        System.out.println("---CHECK CIRCULAR AFTER ADD---");
        head = list.get(0);
        tail = list.get(list.size() - 1);
        System.out.println("head = " + head.value); // -1
        System.out.println("tail = " + tail.value); // 60
        System.out.println("tail.next = " + tail.next.value);
        System.out.println("tail.next==head: " + (tail.next == head)); // phải true

        System.out.println("---TRAVERSE 2 LAPS---");
        BE10LinkedListItem cursor = list.get(0);
        int totalSteps = list.size() * 2;
        for (int i = 0; i < totalSteps; i++) {
            System.out.print(cursor.value);
            if (i < totalSteps - 1)
                System.out.print(" -> ");
            cursor = cursor.next;
        }
        System.out.println();

        System.out.println("---REMOVE ALL UNTIL EMPTY---");
        while (list.size() > 0) {
            list.poll();
            System.out.println("size after poll: " + list.size());
            if (list.size() > 0) {
                head = list.get(0);
                tail = list.get(list.size() - 1);
                System.out.println(" tail.next==head: " + (tail.next == head));
            }
        }
        System.out.println("List is empty. head = " + list.getHead());
    }
}