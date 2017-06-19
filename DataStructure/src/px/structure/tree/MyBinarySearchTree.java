package px.structure.tree;

public class MyBinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	private class BinaryNode<AnyType> {
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
		
		public BinaryNode(AnyType theElement) {
			this(theElement, null, null);
		}
		
		public BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
			element = theElement;
			left = lt;
			right = rt;
		}
	}
	
	private BinaryNode<AnyType>	root ;
	
	public MyBinarySearchTree() {
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean contains(AnyType x) {
		return contains(x, root);
	}
	
	public AnyType findMax() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return findMax(root).element;
	}
	
	public AnyType findMin() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return findMin(root).element;
	}
	
	public void insert(AnyType x) {
		root = insert(x, root);
	}
	
	public void remove(AnyType x) {
		root = remove(x, root);
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if (t == null) {
			return false;
		}
		int compareResults = x.compareTo(t.element);
		if (compareResults < 0) {
			return contains(x, root.left);
		} else if (compareResults > 0) {
			return contains(x, root.right);
		} else {
			return true;
		}
	}
	
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t == null) {
			return null;
		} else if (t.left == null) {
			return null;
		} else {
			return findMin(t.left);
		}
	}


	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (t != null) {
			while (t.right != null) {
				t = t.right;
			}
			return t;
		}
		return null;
	}
	
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null) {
			return new BinaryNode<AnyType>(x, null, null);
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		} else {
			
		}
		return t;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if (t == null) {
			return t;
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			t.left = remove(x, t.left);
		} else if (compareResult > 0) {
			t.right = remove(x, t.right);
		} else if (t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else {
			t = t.left == null ? t.right : t.left;
		}
		return t;
	}

	private void printTree(BinaryNode<AnyType> t) {
		if (t.left != null) {
			printTree(t.left);
		}
		System.out.println(t.element);
		if (t.right != null) {
			printTree(t.right);
		}
	}
}
