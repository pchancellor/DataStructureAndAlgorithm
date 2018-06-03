package px.structure.heap;

/**
 * 左式堆的简单实现
 * @author WD
 *
 * @param <AnyType>
 */
public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {

	public LeftistHeap() {
		root = null;
	}
	
	public void merge(LeftistHeap<AnyType> rhs) {
		if (this == rhs) {
			return;
		}
		root = merge(root, rhs.root);
		rhs.root = null;
	}
	
	public void insert(AnyType elem) {
		root = merge(root, new Node<AnyType>(elem));
	}
	
	public AnyType findMin() {
		return root.elem;
	}
	
	public AnyType deleteMin() {
		if (isEmpty()) {
			throw new IllegalStateException("no elements to delete");
		}
		AnyType elem = root.elem;
		root = merge(root.left, root.right);
		return elem;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	/**
	 * 有bug
	 * @param rhs
	 */
	@Deprecated
	public void copyTo(LeftistHeap<AnyType> rhs) {
		rhs.root = root;
	}
	
	public void printHeap() {
		printHeap(root, 0, false);
		System.out.println();
	}
	
	private static class Node<AnyType> {
		
		Node(AnyType elem) {
			this(elem, null, null);
		}
		
		Node(AnyType elem, Node<AnyType> lt, Node<AnyType> rt) {
			this.elem = elem;
			left = lt;
			right = rt;
			npl = 0;
		}
		
		AnyType elem;
		Node<AnyType> left ;
		Node<AnyType> right ;
		int npl ;
		
	}
	
	private Node<AnyType> root ;
	
	private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		if (h1.elem.compareTo(h2.elem) < 0) {
			return merge1(h1, h2);
		} else {
			return merge1(h2, h1);
		}
	}
	/**
	 * h1 contains smaller element, neither are empty
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
		if (h1.left == null) {
			h1.left = h2;
		} else {
			h1.right = merge(h1.right, h2);
			if (h1.left.npl < h1.right.npl) {
				swapChildren(h1);
			}
			h1.npl = h1.right.npl + 1;
		}
		return h1;
	}
	private void swapChildren(Node<AnyType> t) {
		 Node<AnyType> left = t.left;
		 t.left = t.right;
		 t.right = left;
	}
	
	private void printHeap(Node<AnyType> node, int spaceAheah, boolean newLine) {
		if (node == null) {
			return;
		}
		if (newLine) {
			StringBuilder sBuilder = new StringBuilder();
			for (int i = 0; i < spaceAheah; i++) {
				sBuilder.append(" ");
			}
			System.out.print("\n" + sBuilder.toString());
		}
		String output = node.elem + "--";
		System.out.print(output);
		printHeap(node.left, spaceAheah+output.length(), false);
		printHeap(node.right, spaceAheah+output.length(), true);
	}
}
