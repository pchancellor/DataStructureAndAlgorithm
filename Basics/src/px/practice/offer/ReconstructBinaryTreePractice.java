package px.practice.offer;

import px.practice.util.TreeNode;
import px.practice.util.Utils;

public class ReconstructBinaryTreePractice {
	
	public static void main(String[] args) {
		int[] pre = new int[] {1,2,4,7,3,5,6,8};
		int[] in = new int[] {4,7,2,1,5,3,8,6};
		ReconstructBinaryTreePractice tree = new ReconstructBinaryTreePractice();
		TreeNode node = tree.reConstructBinaryTree(pre, in);
		Utils.printTreeWithAfterOrder(node);
	}

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, in, 0, pre.length-1, 0, in.length-1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in, int startPre, int endPre, int startIn, int endIn) {
    	if (startIn > endIn) {
			return null;
		}
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
			if (in[i] == root.val) {
		        root.left = reConstructBinaryTree(pre, in, startPre+1, i-startIn+startPre, startIn, i-1);
		        root.right = reConstructBinaryTree(pre, in, endPre-endIn+i+1, endPre, i+1, endIn);
		        break;
			}
		}
        return root;
    }
}
