import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
	public BinaryTreeNode root;

	public BinaryTree(int value) {
		root = new BinaryTreeNode(value);
	}

	public boolean search(int value) {
		return searchWithRecursion(root, value);
	}

	public boolean searchWithRecursion(BinaryTreeNode node, int value) {
		if (node == null)
			return false;

		if (node.value == value)
			return true;

		if (node.value > value) {
			return searchWithRecursion(node.left, value);
		} else {
			return searchWithRecursion(node.right, value);
		}
	}

	public void addWithRecursion(BinaryTreeNode node, int value) {
		if (node.value == value)
			return;

		if (node.value > value) {
			if (node.left == null) {
				node.left = new BinaryTreeNode(value);
				return;
			}

			addWithRecursion(node.left, value);
		} else {
			if (node.right == null) {
				node.right = new BinaryTreeNode(value);
				return;
			}

			addWithRecursion(node.right, value);
		}
	}

	public void add(int value) {
		addWithRecursion(root, value);
	}

	public void displayEachLevel() {
		Queue<BinaryTreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			BinaryTreeNode curNode = nodes.poll();

			if (curNode.left != null) {
				System.out.println("root: " + curNode.value + " - left: " + curNode.left.value);
				nodes.add(curNode.left);
			}
			if (curNode.right != null) {
				System.out.println("root: " + curNode.value + " - right: " + curNode.right.value);
				nodes.add(curNode.right);
			}
		}
	}
}
