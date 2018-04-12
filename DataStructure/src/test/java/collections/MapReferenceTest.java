package test.java.collections;

import java.util.HashMap;
import java.util.Map;

public class MapReferenceTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("key1", "value");
		modify(map);
		System.out.println(map);
	}

	public static void modify(Map<String, String> map) {
		map.put("key2", "value");
	}
	
}
