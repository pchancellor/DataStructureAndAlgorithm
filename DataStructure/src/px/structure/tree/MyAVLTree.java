package px.structure.tree;

import java.util.Comparator;

public class MyAVLTree<AnyType> {

	private class AVLNode {
		
		public AVLNode(AnyType elem) {
			this(elem, null, null);
		}
		
		public AVLNode(AnyType elem, AVLNode lt, AVLNode rt) {
			element = elem;
			left = lt;
			right = rt;
			height = 0;
		}
		
		AnyType element;
		AVLNode left;
		AVLNode right;
		int height;
		
	}
	
	private Comparator<? super AnyType> comparator ;
	private AVLNode root ;
	
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
	
	public AnyType getRoot() {
		return root.element;
	}
	
	public void printTree() {
		printTree(root);
	}
	
	public void insert(AnyType elem) {
		root = insert(elem, root);
	}
	
	private AVLNode insert(AnyType elem, AVLNode node) {
		if (node == null) {
			return new AVLNode(elem);
		}
		int compareResult = comparator.compare(elem, node.element);
		if (compareResult < 0) {
			node.left = insert(elem, node.left);
			if (height(node.left) - height(node.right) == 2) {
				if (comparator.compare(elem, node.left.element) < 0) {
					node = rotateWithLeftChild(node);
				} else {
					node = doubleWithLeftChild(node);
				}
			}
		} else if (compareResult > 0) {
			node.right = insert(elem, node.right);
			if (height(node.right) - height(node.left) == 2) {
				if (comparator.compare(elem, node.right.element) > 0) {
					node = rotateWithRightChild(node);
				} else {
					node = doubleWithRightChild(node);
				}
			}
		} else {
			//duplicate, do nothing
		}
		recomputeHeight(node);
		return node;
	}
	
	private AVLNode rotateWithLeftChild(AVLNode node) {
		AVLNode left = node.left;
		node.left = left.right;
		left.right = node;
		recomputeHeight(node);
		recomputeHeight(left);
		return left;
	}
	
	private AVLNode doubleWithLeftChild(AVLNode node) {
		//rotate directly
//		AVLNode leftRight = node.left.right;
//		node.left.right = leftRight.left;
//		leftRight.left = node.left;
//		node.left = leftRight.right;
//		leftRight.right = node;
//		recomputeHeight(leftRight.left);
//		recomputeHeight(leftRight.right);
//		recomputeHeight(leftRight);
		node.left = rotateWithRightChild(node.left);
		return rotateWithLeftChild(node);
	}

	private AVLNode rotateWithRightChild(AVLNode node) {
		AVLNode right = node.right;
		node.right = right.left;
		right.left = node;
		recomputeHeight(node);
		recomputeHeight(right);
		return right;
	}
	
	private AVLNode doubleWithRightChild(AVLNode node) {
		node.right = rotateWithLeftChild(node.right);
		return rotateWithRightChild(node);
	}

	public int height(AVLNode node) {
		return node == null ? -1 : node.height;
	}
	
	private void recomputeHeight(AVLNode node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}

	private void printTree(AVLNode t) {
		if (t.left != null) {
			printTree(t.left);
		}
		System.out.print(t.element + "(height:" + t.height + ")  ");
		if (t.right != null) {
			printTree(t.right);
		}
	}
}
