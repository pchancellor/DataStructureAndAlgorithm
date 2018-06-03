package px.practice.util;

public class Utils {

	public static <T> void printArray(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void printList(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
	}

	public static void printList(RandomListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.label + " ");
			listNode = listNode.next;
		}
	}

	public static void printTreeWithAfterOrder(TreeNode root) {
		if (root == null) {
			return ;
		}
    	printTreeWithAfterOrder(root.left);
    	printTreeWithAfterOrder(root.right);
    	System.out.print(root.val + " ");
	}
}
