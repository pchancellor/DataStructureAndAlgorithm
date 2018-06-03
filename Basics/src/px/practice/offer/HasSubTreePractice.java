package px.practice.offer;

import px.practice.util.TreeNode;

public class HasSubTreePractice {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
			return false;
		}
        if (root1.val == root2.val && equalTree(root1, root2)) {
			return true;
		} else {
			return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
		}
    }
    
    private boolean equalTree(TreeNode parent, TreeNode sub) {
		if (sub == null) {
			return true;
		} else if (parent == null) {
			return false;
		}
		return (parent.val == sub.val) && equalTree(parent.left, sub.left) && equalTree(parent.right, sub.right);
	}
}
