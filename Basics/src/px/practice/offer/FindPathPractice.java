package px.practice.offer;

import java.util.ArrayList;

import px.practice.util.TreeNode;

public class FindPathPractice {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		ArrayList<ArrayList<Integer>> results = new FindPathPractice().FindPath(root, 3);
		for (ArrayList<Integer> arrayList : results) {
			System.out.println(arrayList);
		}
	}

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root != null) {
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            sumPath(root, results, list, sum, target);
		}
        return results;
    }

    @SuppressWarnings("unchecked")
	private void sumPath(TreeNode node, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> currentList, int currentSum, int target) {
    	if (node == null) {
			return;
		}
		currentList.add(node.val);
		currentSum += node.val;
    	if (node.left == null && node.right == null) {
    		if (currentSum == target) {
    			results.add((ArrayList<Integer>) currentList.clone());
    		}
		} else {
			sumPath(node.left, results, currentList, currentSum, target);
			sumPath(node.right, results, currentList, currentSum, target);
		}
		currentList.remove(currentList.size()-1);
    }
    
    /*
     * 对路径理解有误，必须要从根节点到叶节点才算路径，到中间节点不算
     */
    @SuppressWarnings({ "unchecked", "unused" })
    private void sumPath2(TreeNode node, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> currentList, int currentSum, int target) {
		if (node == null) {
			return;
		}
		currentList.add(node.val);
		currentSum += node.val;
		if (currentSum == target) {
			results.add((ArrayList<Integer>) currentList.clone());
		}
		sumPath(node.left, results, currentList, currentSum, target);
		sumPath(node.right, results, currentList, currentSum, target);
		currentSum -= node.val;
		currentList.remove(currentList.size()-1);
	}
}
