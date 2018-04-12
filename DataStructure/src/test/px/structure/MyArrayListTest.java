package test.px.structure;

import java.util.Iterator;

import px.structure.list.MyArrayList;

public class MyArrayListTest {

	public static void main(String[] args) {
		MyArrayList<Integer> mList = new MyArrayList<>();
		for (int i = 0; i < 20; i++) {
			mList.add(i);
		}
		System.out.println(mList);
		Iterator<Integer> iterator = mList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() % 2 == 0) {
				iterator.remove();
			}
		}
		System.out.println(mList);
	}

}
