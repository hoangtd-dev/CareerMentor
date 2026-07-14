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

        System.out.println("---CHECK PREV LINKS---");
        // Duyệt từ tail về head thông qua prev
        BE10LinkedListItem cursor = list.getTail();
        while (cursor != null) {
            System.out.print(cursor.value);
            if (cursor.prev != null)
                System.out.print(" <- ");
            cursor = cursor.prev;
        }
        System.out.println();

        System.out.println("---GET BY INDEX---");
        for (int i = 0; i < list.size(); i++) {
            BE10LinkedListItem node = list.get(i);
            System.out.println("get(" + i + ") = " + node.value
                    + "  |  prev = " + (node.prev != null ? node.prev.value : "null"));
        }

        System.out.println("---REMOVE AT LAST---");
        list.removeAtLast(); // xoá 60
        System.out.println("size: " + list.size());
        list.displayAllItems();
        // kiểm tra tail.prev vẫn đúng sau khi xoá
        System.out.println("tail = " + list.getTail().value);
        System.out.println("tail.prev = " + (list.getTail().prev != null
                ? list.getTail().prev.value
                : "null"));

        list.removeAtLast(); // xoá 50
        System.out.println("size: " + list.size());
        list.displayAllItems();

        System.out.println("---REMOVE BY INDEX---");
        list.remove(2); // xoá index 2 (30)
        // kiểm tra prev của node mới tại index 2 trỏ đúng về node trước nó
        BE10LinkedListItem afterRemove = list.get(2);
        System.out.println("node[2] after remove = " + afterRemove.value
                + " | prev = " + (afterRemove.prev != null ? afterRemove.prev.value : "null"));
        System.out.println("size: " + list.size());
        list.displayAllItems();

        System.out.println("---REMOVE FIRST ITEM (poll)---");
        list.poll(); // xoá head
        // head mới phải có prev == null
        System.out.println("new head = " + list.get(0).value);
        System.out.println("new head.prev = " + (list.get(0).prev != null
                ? list.get(0).prev.value
                : "null"));
        System.out.println("size: " + list.size());
        list.displayAllItems();

        System.out.println("---ADD BY INDEX---");
        BE10LinkedListItem item6 = new BE10LinkedListItem(-1);
        BE10LinkedListItem item7 = new BE10LinkedListItem(100);

        list.addAtIndex(item6, 0); // chèn đầu → prev phải null
        list.addAtIndex(item7, 2); // chèn giữa → prev phải trỏ đúng

        System.out.println("size: " + list.size());
        list.displayAllItems();

        // kiểm tra prev của từng node sau khi chèn
        System.out.println("---CHECK PREV AFTER ADD---");
        for (int i = 0; i < list.size(); i++) {
            BE10LinkedListItem node = list.get(i);
            System.out.println("node[" + i + "] = " + node.value
                    + " | prev = " + (node.prev != null ? node.prev.value : "null"));
        }

        System.out.println("---REMOVE AT LAST UNTIL EMPTY---");
        while (list.size() > 0) {
            list.removeAtLast();
            System.out.println("size after removeAtLast: " + list.size());
            if (list.size() > 0)
                list.displayAllItems();
        }
        System.out.println("List is empty. tail = " + list.getTail());
    }
}