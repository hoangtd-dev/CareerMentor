public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        BETreeNode node1 = new BETreeNode(1);
        BETreeNode node2 = new BETreeNode(2);
        BETreeNode node3 = new BETreeNode(3);
        BETreeNode node4 = new BETreeNode(4);
        BETreeNode node5 = new BETreeNode(5);
        BETreeNode node6 = new BETreeNode(6);
        BETreeNode node7 = new BETreeNode(7);

        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        node2.children.add(node5);
        node2.children.add(node6);
        node4.children.add(node7);

        tree.root = node1;

        int bfsTestValue = 11;
        BETreeNode bfsResult = tree.bfSearch(bfsTestValue);
        if (bfsResult != null)
            System.out.println("BFS FOUND");
        else
            System.out.println("BFS NOT FOUND");

        int dfsTestValue = 11;
        BETreeNode dfsResult = tree.dfSearch(tree.root, dfsTestValue);
        if (dfsResult != null)
            System.out.println("DFS FOUND");
        else
            System.out.println("DFS NOT FOUND");
    }
}