public class Main {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);

        arr.removeAtIndex(3);
        arr.removeAtIndex(0);
        for (int i = 0; i < arr.length(); i++) {
            System.out.println(arr.get(i));
        }
    }
}