package px.structure.tree;

import java.util.Comparator;

public class MyAVLTree<AnyType> {

	private class AVLNode<AnyType> {
		
		public AVLNode(AnyType elem) {
			this(elem, null, null);
		}
		
		public AVLNode(AnyType elem, AVLNode<AnyType> lt, AVLNode<AnyType> rt) {
			element = elem;
			left = lt;
			right = rt;
			height = 0;
		}
		
		AnyType element;
		AVLNode<AnyType> left;
		AVLNode<AnyType> right;
		int height;
	}
	
	private Comparator<? super AnyType> comparator ;
	private AVLNode<AnyType> root ;
	
	public MyAVLTree() {
		this(null);
	}
	
	public MyAVLTree(Comparator<? super AnyType> compa) {
		comparator = compa;
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
}
