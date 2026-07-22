import java.util.ArrayList;

public class BETreeNode {
	public int value;
	public ArrayList<BETreeNode> children;

	public BETreeNode(int value) {
		this.value = value;
		this.children = new ArrayList<>();
	}
}
