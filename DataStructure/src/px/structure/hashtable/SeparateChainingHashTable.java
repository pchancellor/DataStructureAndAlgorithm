package px.structure.hashtable;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<AnyType> {

	public SeparateChainingHashTable() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {
		theLists = new LinkedList[nextPrime(size)];
		for (int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<>();
		}
	}
	
	public void insert(AnyType elem) {
		List<AnyType> list = theLists[myhash(elem)];
		if (!list.contains(elem)) {
			list.add(elem);
		}
		if (++currentSize > theLists.length) {
			rehash();
		}
	}
	
	public void remove(AnyType elem) {
		List<AnyType> list = theLists[myhash(elem)];
		if (list.contains(elem)) {
			list.remove(elem);
			currentSize--;
		}
	}
	
	public boolean contains(AnyType elem) {
		List<AnyType> list = theLists[myhash(elem)];
		return list.contains(elem);
	}
	
	public void makeEmpty() {
		for (int i = 0; i < theLists.length; i++) {
			theLists[i].clear();
		}
		currentSize = 0;
	}
	
	public int size() {
		return currentSize;
	}
	
	private static final int DEFAULT_SIZE = 101;//使用质数
	
	private List<AnyType>[] theLists ;
	private int currentSize ;
	
	@SuppressWarnings("unchecked")
	private void rehash() {
		List<AnyType>[] oldLists = theLists;
		theLists = new LinkedList[nextPrime(2*oldLists.length)];
		for (int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<>();
		}
		currentSize = 0;
		for (int i = 0; i < oldLists.length; i++) {
			for (AnyType elem : oldLists[i]) {
				insert(elem);
			}
		}
	}
	
	private int myhash(AnyType elem) {
		int hashVal = elem.hashCode();
		hashVal %= theLists.length;
		if (hashVal < 0) {
			hashVal += theLists.length;
		}
		return hashVal;
	}
	
	private int nextPrime(int num) {
		
		return num;
	}
}
