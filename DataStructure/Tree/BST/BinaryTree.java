import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
	public BinaryTreeNode root;

	public BinaryTree(int value) {
		root = new BinaryTreeNode(value);
	}

	private BinaryTreeNode add(BinaryTreeNode node, int value) {
		if (node == null)
			return new BinaryTreeNode(value);

		if (value < node.value) {

		} else if (value > node.value) {

		}
		return node;
	}

	private BinaryTreeNode fixLeft(BinaryTreeNode parent) {
		BinaryTreeNode child = parent.left;
		if (child.balance == -1) {
			// Implement Logic
			return child;
		} else {
			// Implement Logic
			return grandchild;
		}
	}

	private BinaryTreeNode fixRight(BinaryTreeNode parent) {
		BinaryTreeNode child = parent.right;
		if (child.balance == 1) {
			// Implement Logic
			return child;
		} else {
			// Implement Logic
			return grandchild;
		}
	}

	public boolean search(int value) {
		BinaryTreeNode cur = root;
		while (cur != null) {
			if (value < cur.value)
				cur = cur.left;
			else if (value > cur.value)
				cur = cur.right;
			else
				return true;
		}
		return false;
	}
}
