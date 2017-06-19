package px.structure.test;

import java.util.Random;

import px.structure.tree.MyBinarySearchTree;

public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		MyBinarySearchTree<Integer> mTree = new MyBinarySearchTree<>();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			mTree.insert(random.nextInt(100));
		}
		mTree.printTree();
	}

}
