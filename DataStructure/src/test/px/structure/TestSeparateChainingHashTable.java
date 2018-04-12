package test.px.structure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import px.structure.hashtable.SeparateChainingHashTable;

public class TestSeparateChainingHashTable {

	public static void main(String[] args) {
		SeparateChainingHashTable<Integer> hashTable = new SeparateChainingHashTable<>();
		Set<Integer> set = new HashSet<>();
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int num = random.nextInt();
			hashTable.insert(num);
			set.add(num);
		}
		Iterator<Integer> iterator = set.iterator();
		System.out.println("hashtable size " + hashTable.size());
		System.out.println("hashset size " + set.size());
		int count = 0;
		while (iterator.hasNext()) {
			Integer elem = (Integer) iterator.next();
			if (!hashTable.contains(elem)) {
				System.out.println(elem + " not included in hashtable");
				count++;
			}
		}
		System.out.println("number of elems not included in hashtable " + count);
	}

}
