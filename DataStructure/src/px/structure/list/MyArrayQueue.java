package px.structure.list;

public class MyArrayQueue<T> extends MyQueue<T> {

	private Object[] theArray ;
	private static final int DEFAULT_CAPACITY = 10 ;
	private int front ;
	private int back ;
	private int elemCount ;
	
	public MyArrayQueue () {
		theArray = new Object[DEFAULT_CAPACITY];
		elemCount = front = back = 0;
	}
	
	@Override
	public void enqueue(T elem) {
		if (elemCount >= theArray.length) {
			Object[] old = theArray ;
			theArray = new Object[2*old.length];
			System.arraycopy(old, 0, theArray, 0, old.length);
		}
		if (back == theArray.length) {
			back %= theArray.length;
		}
		theArray[back++] = elem;
		elemCount++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		if (elemCount <= 0) {
			return null;
		}
		if (front == theArray.length) {
			front %= theArray.length;
		}
		Object elem = theArray[front++];
		elemCount--;
		return (T) elem;
	}
	
	public int getSize() {
		return elemCount;
	}

}
