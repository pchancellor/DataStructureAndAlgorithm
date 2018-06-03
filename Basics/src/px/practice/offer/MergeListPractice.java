package px.practice.offer;

import px.practice.util.ListNode;
import px.practice.util.Utils;

public class MergeListPractice {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node = head1;
		for (int i = 1; i < 5; i++) {
			node = node.next = new ListNode(2*i+1);
		}
		ListNode head2 = new ListNode(2);
		node = head2;
		for (int i = 2; i < 5; i++) {
			node = node.next = new ListNode(2*i);
		}
		Utils.printList(head1);
		System.out.println();
		Utils.printList(head2);
		System.out.println();
		Utils.printList(new MergeListPractice().Merge(head1, head2));
	}
	
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode mergeList, trace ;
        if (list1 == null && list2 == null) {
			return null;
		} else if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else {
			if (list1.val > list2.val) {
				mergeList = list2;
				list2 = list2.next;
			} else {
				mergeList = list1;
				list1 = list1.next;
			}
		}
		trace = mergeList;
        while (list1 != null && list2 != null) {
        	if (list1.val > list2.val) {
        		trace.next = list2;
        		list2 = list2.next;
			} else {
				trace.next = list1;
        		list1 = list1.next;
			}
        	trace = trace.next;
		}
        if (list1 == null) {
			trace.next = list2;
		} else {
			trace.next = list1;
		}
        return mergeList;
    }
}
