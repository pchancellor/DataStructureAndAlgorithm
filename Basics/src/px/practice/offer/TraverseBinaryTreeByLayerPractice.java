package px.practice.offer;

import java.util.ArrayList;

import px.practice.util.TreeNode;

public class TraverseBinaryTreeByLayerPractice {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
			return result;
		}
        ArrayList<TreeNode> tmpNodes = new ArrayList<>();
        TreeNode tmp;
        tmpNodes.add(root);
        while (!tmpNodes.isEmpty()) {
        	tmp = tmpNodes.remove(0);
			result.add(tmp.val);
			if (tmp.left != null) {
				tmpNodes.add(tmp.left);
			}
			if (tmp.right != null) {
				tmpNodes.add(tmp.right);
			}
		}
        return result;
    }
}
