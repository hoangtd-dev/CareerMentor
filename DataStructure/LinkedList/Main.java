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
        
        System.out.println("---GET BY INDEX---");
        System.out.println(list.get(0).value);
        System.out.println(list.get(1).value);
        System.out.println(list.get(2).value);
        System.out.println(list.get(3).value);
        System.out.println(list.get(4).value);
        System.out.println(list.get(5).value);
        
        System.out.println("---REMOVE BY INDEX---");
        
        list.remove(2);
        list.remove(3);
        
        System.out.println("size: " + list.size());
        list.displayAllItems();
        System.out.println("---REMOVE FIRST ITEM---");
        
        list.poll();
        
        System.out.println("size: " + list.size());
        list.displayAllItems();
        
        System.out.println("---ADD BY INDEX---");
        
        BE10LinkedListItem item6 = new BE10LinkedListItem(-1);
        BE10LinkedListItem item7 = new BE10LinkedListItem(100);
        list.addAtIndex(item6, 0);
        list.addAtIndex(item7, 2);
        
        System.out.println("size: " + list.size());
        list.displayAllItems();
    }
}