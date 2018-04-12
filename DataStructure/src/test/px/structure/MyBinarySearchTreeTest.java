package test.px.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import px.structure.tree.MyBinarySearchTree;

public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		MyBinarySearchTree<Integer> mTree = new MyBinarySearchTree<>();
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int elem = random.nextInt(100);
			mTree.insert(elem);
			if (i%2==0) list.add(elem);
		}
		System.out.println("list:"+list);
		mTree.printTree();
		for (Integer i : list) {
			mTree.remove(i);
		}
		System.out.println();
		mTree.printTree();
	}

}
