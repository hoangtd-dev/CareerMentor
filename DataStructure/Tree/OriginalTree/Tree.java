import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public BETreeNode root;

	public BETreeNode bfSearch(int value) {
		Queue<BETreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			BETreeNode currentNode = nodes.poll();

			if (currentNode.value == value)
				return currentNode;

			for (BETreeNode item : currentNode.children) {
				nodes.add(item);
			}
		}

		return null;
	}

	public BETreeNode dfSearch(BETreeNode node, int value) {
		if (value == node.value)
			return node;

		for (BETreeNode item : node.children) {
			BETreeNode result = dfSearch(item, value);
			if (result != null)
				return result;
		}

		return null;
	}
}
