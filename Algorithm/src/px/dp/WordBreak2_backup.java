package px.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2_backup {

	//TODO: 待修正
	public static void main(String[] args) {
//		String string = "catsanddog";//"cat", "cats", "and", "sand", "dog"
//		String string = "a";
		String string = "aaaaaaa";
		Set<String> dic = new HashSet<>();
//		dic.add("cat");	dic.add("cats");	dic.add("and");
//		dic.add("sand");	dic.add("dog");
		dic.add("a");
		dic.add("aaaa");	dic.add("aa");
		System.out.println(new WordBreak2_backup().wordBreak(string, dic));
	}

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> results = new ArrayList<>();
		Node[] nodes = new Node[s.length()];
		int startLength ;
		for (startLength = 1; startLength <= nodes.length; startLength++) {
			if (dict.contains(s.substring(0, startLength))) {
				nodes[startLength-1] = new Node();
				nodes[startLength-1].index = -1;//-1表示指向自身
				break;
			}
		}
		for (int curLength = startLength+1; curLength <= nodes.length; curLength++) {
			for (int pos = curLength; pos >= startLength; pos--) {
				if (nodes[pos-1] != null && dict.contains(s.substring(pos, curLength))) {
					if (nodes[curLength-1] == null) {
						nodes[curLength-1] = new Node();
						nodes[curLength-1].index = pos-1;
					} else {
						nodes[curLength-1].next = new Node();
						nodes[curLength-1].next.index = pos-1;
					}
				}
			}
			if (dict.contains(s.substring(0, curLength))) {
				if (nodes[curLength-1] == null) {
					nodes[curLength-1] = new Node();
					nodes[curLength-1].index = -1;
				} else {
					nodes[curLength-1].next = new Node();
					nodes[curLength-1].next.index = curLength;
				}
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		print(sBuilder, nodes, s, nodes.length-1, results, null);
		return results;
    }
	
	public void print(StringBuilder sBuilder, Node[] nodes, String s, int currentIndex, List<String> results, String currentS) {
		while (nodes[currentIndex] != null) {
			if (nodes[currentIndex].next != null) {
				currentS = sBuilder.toString();
			}
			int prevIndex ;
			if ((prevIndex = nodes[currentIndex].index) != -1) {
				sBuilder.insert(0, s.substring(prevIndex+1, currentIndex+1)).insert(0, " ");
				print(sBuilder, nodes, s, nodes[currentIndex].index, results, currentS);
			} else {
				sBuilder.insert(0, s.substring(0, currentIndex+1));
				results.add(sBuilder.toString());
				sBuilder.setLength(0);
				sBuilder.append(currentS);
			}
			nodes[currentIndex] = nodes[currentIndex].next;
		}
	}
	
	static class Node {
		int index ;
		Node next ;
	}
}
