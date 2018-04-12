package test.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ForeachTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		System.out.println(list);
		for (Integer integer : list) {
			integer ++;
			System.out.println(integer);
		}
		System.out.println(list);
	}

}
