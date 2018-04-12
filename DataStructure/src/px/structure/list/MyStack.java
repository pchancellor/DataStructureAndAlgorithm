package px.structure.list;

public class MyStack<AnyType> {
	
	private Object[] elems ;
	private int topOfStack = -1;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public MyStack(int capacity) {
		elems = new Object[capacity];
	}
	
	public boolean push(AnyType val) {
		if (topOfStack+1 >= elems.length) {
			Object[] old = elems;
			elems = new Object[2*elems.length];
			System.arraycopy(old, 0, elems, 0, old.length);
		}
		elems[++topOfStack] = val;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public AnyType pop() {
		if (topOfStack < 0) {
			throw new ArrayIndexOutOfBoundsException(topOfStack);
		}
		return (AnyType) elems[topOfStack--];
	}
	
	@SuppressWarnings("unchecked")
	public AnyType peek() {
		if (topOfStack < 0) {
			return null;
		}
		return (AnyType) elems[topOfStack];
	}
}
