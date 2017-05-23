package px.structure.test;

import java.util.Iterator;

import px.structure.list.MyLinkedList;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList<Integer> mList = new MyLinkedList<>();
		for (int i = 0; i < 20; i++) {
			mList.add(i);
		}
		Iterator<Integer> iterator = mList.iterator();
		for (iterator = mList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		iterator = mList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() % 2 == 0) {
				iterator.remove();
			}
		}
		for (iterator = mList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

}
