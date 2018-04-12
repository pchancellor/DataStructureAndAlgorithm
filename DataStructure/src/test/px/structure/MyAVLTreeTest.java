package test.px.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import px.structure.tree.MyAVLTree;

public class MyAVLTreeTest {

	public static void main(String[] args) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		MyAVLTree<Integer> mTree = new MyAVLTree<>(comparator);
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int elem = random.nextInt(100);
			mTree.insert(elem);
			list.add(elem);
		}
		System.out.println("list:"+list);
		System.out.println("root:"+mTree.getRoot());
		mTree.printTree();
	}

}
