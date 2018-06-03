package px.java.features;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaCollectionTest {

	public static void main(String[] args) {
//		Set<String> set = new HashSet<>();
//		set.add("");
		testListRemoveOverload();
	}

	public static void testListRemoveOverload() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(10-i);
		}
		Integer integer = 2;
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		list.remove(integer);
		System.out.println(list);
		list.remove(new Integer(3));
		System.out.println(list);
	}
	
}
