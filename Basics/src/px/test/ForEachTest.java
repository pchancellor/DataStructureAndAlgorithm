package px.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {

	public static void main(String[] args) {
		List<Map<Integer, Integer>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(i, i);
			list.add(map);
		}
		int i = 0;
		for (Map<Integer, Integer> map : list) {
//			map.put(i, ++i);
			map = new HashMap<>();
		}
		System.out.println(list);
	}
	
}
