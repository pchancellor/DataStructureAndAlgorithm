package px.structure.heap;

/**
 * 二叉堆的简单实现
 * @author WD
 *
 * @param <AnyType>
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

	public BinaryHeap() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {
		array = (AnyType[]) new Comparable[capacity+1];
	}

	@SuppressWarnings("unchecked")
	public BinaryHeap(AnyType[] elems) {
		currentSize = elems.length;
		array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
		System.arraycopy(elems, 0, array, 1, currentSize);
		buildHeap();
	}
	
	public void insert(AnyType elem) {
		if (currentSize == array.length - 1) {
			enlargeArray(array.length * 2 + 1);
		}
		int percolatePos = ++currentSize;
		while (percolatePos > 1 && elem.compareTo(array[percolatePos/2]) < 0) {
			array[percolatePos] = array[percolatePos/2];
			percolatePos /= 2;
		}
		array[percolatePos] = elem;
	}
	
	public AnyType findMin() {
		return array[1];
	}
	
	public AnyType deleteMin() {
		if (isEmpty()) {
			throw new IllegalStateException("no elem to delete");
		}
		AnyType elem = array[1];
		array[1] = array[currentSize--];
		percolateDown(1);
		return elem;
	}
	
	public void replaceMin(AnyType elem) {
		if (isEmpty()) {
			throw new IllegalStateException("no elem to replace");
		}
		array[1] = elem;
		percolateDown(1);
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public void makeEmpty() {
		currentSize = 0;
	}
	
	public int size() {
		return currentSize;
	}
	
	private static final int DEFAULT_SIZE = 10;
	
	private int currentSize ;
	private AnyType[] array ;//元素从1开始？
	
	private void percolateDown(int hole) {
		AnyType tmp = array[hole];
		int backupChild = 2*hole;
		while (backupChild <= currentSize) {
			if (backupChild+1 <= currentSize && array[backupChild].compareTo(array[backupChild+1]) > 0) {
				backupChild++;
			} 
			if (array[backupChild].compareTo(tmp) > 0) {
				break;
			}
			array[hole] = array[backupChild];
			hole = backupChild;
			backupChild *= 2;
		}
		array[hole] = tmp;
	}
	
	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void enlargeArray(int newSize) {
		AnyType[] old = array;
		array = (AnyType[]) new Comparable[newSize];
		System.arraycopy(old, 0, array, 0, currentSize);
	}
}
