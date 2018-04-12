package px.practice.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityTravel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int L = scanner.nextInt();
		int[] cityNum = new int[n];
		cityNum[0] = 0;
		for (int i = 1; i < n; i++) {
			cityNum[i] = scanner.nextInt();
		}
		
	
		scanner.close();
	}

	static class Tree {
		
		Node root;
		
		static class Node {
			int depth ;
			int id ;
			List<Node> childs ;
			
			public Node(int id) {
				this.id = id;
				childs = new ArrayList<>();
			}
		}
		
		public Tree(int[] nodes) {
			root = new Node(0);
			
		}
	}
}
