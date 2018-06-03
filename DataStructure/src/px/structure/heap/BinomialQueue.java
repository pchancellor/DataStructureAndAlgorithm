package px.structure.heap;

/**
 * 二项队列的简单实现
 * @author WD
 *
 * @param <AnyType>
 */
public class BinomialQueue<AnyType extends Comparable<? super AnyType>> {

	@SuppressWarnings("unchecked")
	public BinomialQueue() {
		theTrees = new Node[DEFAULT_TREE];
		theTrees[0] = null;
		currentSize = 0;
	}
	@SuppressWarnings("unchecked")
	public BinomialQueue(AnyType elem) {
		if (elem == null) {
			return;
		}
		theTrees = new Node[DEFAULT_TREE];
		theTrees[0] = new Node<AnyType>(elem);
		currentSize = 1;
	}
	
	public void merge(BinomialQueue<AnyType> rhs) {
		if (this == rhs) {
			return;
		}
		currentSize += rhs.currentSize;
		if (currentSize > capacity()) {
			expandTheTrees(Math.max(theTrees.length, rhs.theTrees.length)+1);
		}
		Node<AnyType> carry = null;
		for (int i = 0, j = 1; j <= currentSize; i++, j*=2) {
			Node<AnyType> t1 = theTrees[i];
			Node<AnyType> t2 = i < rhs.theTrees.length ? rhs.theTrees[i] : null;
			int whichCase = t1 == null ? 0 : 1;
			whichCase += t2 == null ? 0 : 2;
			whichCase += carry == null ? 0 : 4;
			switch (whichCase) {
			case 0: break;
			case 1: break;
			case 2: 
				theTrees[i] = t2;
				break;
			case 3: 
				theTrees[i] = null;
				carry = combineTrees(t1, t2);
				break;
			case 4: 
				theTrees[i] = carry;
				carry = null;
				break;
			case 5: 
				theTrees[i] = null;
				carry = combineTrees(t1, carry);
				break;
			case 6: 
				carry = combineTrees(t2, carry);
				break;
			case 7: 
				theTrees[i] = carry;
				carry = combineTrees(t1, t2);
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < rhs.theTrees.length; i++) {
			rhs.theTrees[i] = null;
		}
		rhs.currentSize = 0;
	}
	public void insert(AnyType elem) {
		merge(new BinomialQueue<AnyType>(elem));
	}
	public AnyType findMin() {
		if (isEmpty()) {
			return null;
		}
		return theTrees[findMinIndex()].elem;
	}
	public AnyType deleteMin() {
		if (isEmpty()) {
			throw new IllegalStateException("no element to delete");
		}
		int index = findMinIndex();
		Node<AnyType> deleteTree = theTrees[index];
		AnyType elem = deleteTree.elem;
		BinomialQueue<AnyType> deleteQueue = new BinomialQueue<AnyType>();
		deleteQueue.expandTheTrees(index+1);
		deleteQueue.currentSize = (1<<index) - 1;
		Node<AnyType> tree = deleteTree.leftChild;
		int i = index;
		while (tree != null) {
			deleteQueue.theTrees[--i] = tree;
			tree = tree.nextSibling;
			deleteQueue.theTrees[i].nextSibling = null;
		}
		theTrees[index] = null;
		currentSize -= deleteQueue.currentSize + 1;
		merge(deleteQueue);
		return elem;
	}
	
	public boolean isEmpty() {
		return currentSize <= 0;
	}
	public void makeEmpty() {
		currentSize = 0;
		theTrees = null;
	}
	public int size() {
		return currentSize;
	}
	
	private static class Node<AnyType> {
		public Node(AnyType elem) {
			this(elem, null, null);
		}
		public Node(AnyType elem, Node<AnyType> lt, Node<AnyType> nt) {
			this.elem = elem;
			leftChild = lt;
			nextSibling = nt;
		}
		
		@Override
		public String toString() {
			return elem.toString();
		}
		
		AnyType elem;
		Node<AnyType> leftChild ;
		Node<AnyType> nextSibling ;
	}
	
	private static final int DEFAULT_TREE = 1;
	
	private int currentSize ;
	private Node<AnyType>[] theTrees ;
	
	@SuppressWarnings("unchecked")
	private void expandTheTrees(int newNumTrees) {
		Node<AnyType>[] oldTrees = theTrees;
		theTrees = new Node[newNumTrees];
		System.arraycopy(oldTrees, 0, theTrees, 0, oldTrees.length);
	}
	private Node<AnyType> combineTrees(Node<AnyType> t1, Node<AnyType> t2) {
		if (t1.elem.compareTo(t2.elem) > 0) {
			return combineTrees(t2, t1);
		}
		t2.nextSibling = t1.leftChild;
		t1.leftChild = t2;
		return t1;
	}
	
	private int capacity() {
		return (1 << theTrees.length) - 1;
	}
	private int findMinIndex() {
		if (isEmpty()) {
			return -1;
		}
		int index = 0;
		for (int i = 1; i < theTrees.length; i++) {
			if (theTrees[index] == null && theTrees[i] != null) {
				index = i;
			} else if (theTrees[index] != null && theTrees[i] != null) {
				index = theTrees[i].elem.compareTo(theTrees[index].elem) < 0 ? i : index;
			}
		}
		return index;
	}
}
