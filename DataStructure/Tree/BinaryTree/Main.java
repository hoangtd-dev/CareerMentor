public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(5);
        bt.add(3);
        bt.add(1);
        bt.add(4);
        bt.add(2);
        bt.add(9);
        bt.add(7);
        bt.add(11);
        bt.add(8);

        bt.displayEachLevel();

        System.out.println(bt.search(2));
        System.out.println(bt.search(15));
        System.out.println(bt.search(6));
        System.out.println(bt.search(8));

        bt.add(6);
        System.out.println(bt.search(6));
    }
}