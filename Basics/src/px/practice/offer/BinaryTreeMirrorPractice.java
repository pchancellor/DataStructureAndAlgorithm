package px.practice.offer;

import java.util.ArrayList;
import java.util.List;

import px.practice.util.TreeNode;

public class BinaryTreeMirrorPractice {

    public void Mirror(TreeNode root) {
    	if (root == null) {
			return;
		}
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public void MirrorNonRecursive(TreeNode root) {
    	if (root == null) {
			return;
		}
    	List<TreeNode> list = new ArrayList<>();
    	list.add(root);
    	while (!list.isEmpty()) {
			TreeNode node = list.remove(0);
	    	if (node.left != null) {
	        	list.add(node.left);
			}
	    	if (node.right != null) {
	        	list.add(node.right);
			}
	        TreeNode tmp = node.left;
	        node.left = node.right;
	        node.right = tmp;
		}
    }
}
