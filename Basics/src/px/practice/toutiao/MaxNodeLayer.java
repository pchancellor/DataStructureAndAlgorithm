package px.practice.toutiao;

public class MaxNodeLayer {
	
	static class Node {
		Node[] sons;
	}

	void dfsFind(Node node, int dep, int counter[]) {
		if (node == null) {
			return ;
		}
	    counter[dep]++;
	    for(int i = 0; i < node.sons.length; i++) {
	        dfsFind(node.sons[i], dep, counter);
	    }
	}

	int find(Node root, int maxDep) {
		if (root == null) {
			return 0;
		}
	    int[] depCounter = new int[100000];
	    dfsFind(root, 0, depCounter);

	    int max = 0, maxNodeDep = 1;
	    for (int i = 1; i <= maxDep; i++) {
	        if (depCounter[i] > max) {
	            max = depCounter[i];
	            maxNodeDep = i;
	        }
	    }
	    return maxNodeDep;
	}
}
