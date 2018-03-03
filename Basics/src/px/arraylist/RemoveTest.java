package px.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveTest {

	public static void main(String[] args) {
//		testRemove();
		testArraysAslist();
	}
	
	public static void testRemove() {
		List<Integer> integers = new ArrayList<>(5);
	    integers.add(1);
	    integers.add(2);
	    integers.add(2);
	    integers.add(4);
	    integers.add(5);
	    for (int i = 0; i < integers.size(); i++) {
	        if (integers.get(i)%2==0){
	            integers.remove(i);
	        }
	    }
	    System.out.println(integers);
	}
	
	public static void testArraysAslist() {
//		String[] arr = new String[] {"a", "b"};
		Integer[] arr = new Integer[]{1,2,3};
		List list = Arrays.asList(arr);
		System.out.println(list.size());
//		list.add("c");
		System.out.println(list);
	}
}
