package px.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class UndirectedGraphNode {
	
	public int label;
	public ArrayList<UndirectedGraphNode> neighbors;
	
	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);
		UndirectedGraphNode cloneNode = cloneGraph(node);
		System.out.println(cloneNode.label);
		cloneNode.neighbors.forEach(neighbor -> System.out.println(neighbor.label));
	}
	
	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
	
	/**
	 * bfs遍历
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
		Set<Integer> konwnNodes = new HashSet<>();
		Map<Integer, UndirectedGraphNode> cloneNodes = new HashMap<>();
        queue.add(node);
        cloneNodes.put(node.label, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
			UndirectedGraphNode tmpNode = queue.poll();
			if (konwnNodes.contains(tmpNode.label)) {
				continue;
			}
			UndirectedGraphNode cloneNode = cloneNodes.get(tmpNode.label);
			tmpNode.neighbors.forEach(neighbor->{
				queue.add(neighbor);
				cloneNodes.putIfAbsent(neighbor.label, new UndirectedGraphNode(neighbor.label));
				cloneNode.neighbors.add(cloneNodes.get(neighbor.label));
			});
			konwnNodes.add(tmpNode.label);
		}
        return cloneNodes.get(node.label);
    }
	
	/**
	 * 序列化的方式
	 * @param node
	 * @return
	 */
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Set<Integer> konwnNodes = new HashSet<>();
		StringBuilder sBuilder = new StringBuilder();
		Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
		queue.add(node);
		//序列化
		while (!queue.isEmpty()) {
			UndirectedGraphNode tmpNode = queue.poll();
			if (konwnNodes.contains(tmpNode.label)) {
				continue;
			}
			sBuilder.append(tmpNode.label);
			tmpNode.neighbors.forEach(neighbor -> {
				sBuilder.append(",").append(neighbor.label);
				if (!konwnNodes.contains(neighbor.label)) {
					queue.add(neighbor);
				}
			});
			sBuilder.append("#");
			konwnNodes.add(tmpNode.label);
		}
		//反序列化
		Map<Integer, UndirectedGraphNode> allNodes = new HashMap<>();
		String nodeString = sBuilder.substring(0, sBuilder.length()-1);
		String[] nodesString = nodeString.split("#");
		for (int i = 0; i < nodesString.length; i++) {
			int label = Integer.valueOf(nodesString[i].split(",")[0]);
			allNodes.put(label, new UndirectedGraphNode(label));
		}
		for (int i = 0; i < nodesString.length; i++) {
			String[] tmpStr = nodesString[i].split(",");
			for (int j = 1; j < tmpStr.length; j++) {
				allNodes.get(Integer.valueOf(tmpStr[0])).neighbors.add(allNodes.get(Integer.valueOf(tmpStr[j])));
			}
		}
		return allNodes.get(Integer.valueOf(nodesString[0].split(",")[0]));
	}
	
}
