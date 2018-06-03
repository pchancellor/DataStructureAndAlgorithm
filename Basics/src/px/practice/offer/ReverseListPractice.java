package px.practice.offer;

import px.practice.util.ListNode;
import px.practice.util.Utils;

public class ReverseListPractice {
	
	public static void main(String[] args) {
		ReverseListPractice outer = new ReverseListPractice();
		ListNode head = new ListNode(1);
		ListNode node = head;
		for (int i = 1; i < 5; i++) {
			node = node.next = new ListNode(i+1);
		}
		Utils.printList(head);
		head = outer.ReverseList(head);
		System.out.println();
		Utils.printList(head);
	}
	
    public ListNode ReverseList(ListNode head) {
    	ListNode node = null, tmp ;
    	while (head != null) {
			tmp = head.next;
			head.next = node;
			node = head;
			head = tmp;
		}
    	return node;
    }
}
