package px.structure.tree;

public class MyBinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	private class BinaryNode {
		AnyType element;
		BinaryNode left;
		BinaryNode right;
		
		public BinaryNode(AnyType theElement) {
			this(theElement, null, null);
		}
		
		public BinaryNode(AnyType theElement, BinaryNode lt, BinaryNode rt) {
			element = theElement;
			left = lt;
			right = rt;
		}
	}
	
	private BinaryNode	root ;
	
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
	
	private boolean contains(AnyType x, BinaryNode t) {
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
	
	private BinaryNode findMin(BinaryNode t) {
		if (t == null) {
			return null;
		} else if (t.left == null) {
			return t;
		} else {
			return findMin(t.left);
		}
	}


	private BinaryNode findMax(BinaryNode t) {
		if (t != null) {
			while (t.right != null) {
				t = t.right;
			}
			return t;
		}
		return null;
	}
	
	private BinaryNode insert(AnyType x, BinaryNode t) {
		if (t == null) {
			return new BinaryNode(x);
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		} else {
			//duplicate, do nothing
		}
		return t;
	}

	private BinaryNode remove(AnyType x, BinaryNode t) {
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

	private void printTree(BinaryNode t) {
		if (t.left != null) {
			printTree(t.left);
		}
		System.out.print(t.element + "  ");
		if (t.right != null) {
			printTree(t.right);
		}
	}
}
