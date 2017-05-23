package px.structure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	
	private static class Node<AnyType> {
		
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> pre, Node<AnyType> next) {
			this.data = data;
			this.prev = pre;
			this.next = next;
		}
	}
	
	public MyLinkedList() {
		clear();
	}

	public void clear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount++;
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void add(AnyType x) {
		add(size(), x);
	}
	
	public void add(int index, AnyType x) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		addBefore(getNode(index), x);
	}
	
	public AnyType get(int index) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return getNode(index).data;
	}
	
	public AnyType set(int index, AnyType newVal) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node<AnyType> old = getNode(index);
		AnyType oldVal = old.data;
		old.data = newVal;
		return oldVal;
	}
	
	public AnyType remove(int index) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return remove(getNode(index));
	}
	
	private void addBefore(Node<AnyType> p, AnyType x) {
		p.prev = p.prev.next = new Node<AnyType>(x, p.prev, p);
		theSize++;
		modCount++;
	}
	
	private AnyType remove(Node<AnyType> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;
		return p.data;
	}
	
	private Node<AnyType> getNode(int index) {
		Node<AnyType> node ;
		if (index < size()/2) {
			node = beginMarker.next;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = endMarker;
			for (int i = size()-1; i > index; i--) {
				node = node.prev;
			}
		}
		
		return node;
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<AnyType> {
		
		private Node<AnyType> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public AnyType next() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			AnyType data = current.data;
			current = current.next;
			okToRemove = true;
			return data;
		}
		
		public void remove() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
	}
	
	private int theSize ;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;

}
