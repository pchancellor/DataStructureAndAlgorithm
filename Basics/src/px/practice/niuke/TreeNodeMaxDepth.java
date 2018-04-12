package px.practice.niuke;

public class TreeNodeMaxDepth {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public class Solution {
		
	    public int maxDepth(TreeNode root) {
	    	if (root == null) {
				return 0;
			}
	        return findLargestDepth(root, 0);
	    }
	    
	    public int findLargestDepth(TreeNode node, int currentDepth) {
	    	if (node == null) {
				return currentDepth;
			}
	    	currentDepth++;
	    	if (node.left == null && node.right == null) {
				return currentDepth;
			} else {
				return max(findLargestDepth(node.left, currentDepth), findLargestDepth(node.right, currentDepth));
			}
		}
	    
	    public int max(int a, int b) {
			return a > b ? a : b;
		}
	    
	}
}
