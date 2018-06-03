package px.practice.offer;

import px.practice.util.TreeNode;

public class BSTree2LinkedListPractice {

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		return Convert(pRootOfTree, false);
    }
	
	private TreeNode Convert(TreeNode node, boolean returnMaxChild) {
		if (node.left != null) {
			node.left = Convert(node.left, true);
			node.left.right = node;
		}
		if (node.right != null) {
			node.right = Convert(node.right, false);
			node.right.left = node;
		}
		if (returnMaxChild) {
			while (node.right != null) {
				node = node.right;
			}
		} else {
			while (node.left != null) {
				node = node.left;
			}
		}
		return node;
	}
}
