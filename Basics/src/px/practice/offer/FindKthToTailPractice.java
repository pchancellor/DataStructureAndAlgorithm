package px.practice.offer;

import px.practice.util.ListNode;

public class FindKthToTailPractice {

    public ListNode FindKthToTail(ListNode head,int k) {
    	ListNode target = head;
    	ListNode tmp = head;
    	for (int i = 0; i < k; i++) {
			if (tmp == null) {
				return null;
			}
			tmp = tmp.next;
		}
    	while (tmp != null) {
			tmp = tmp.next;
			target = target.next;
		}
    	return target;
    }
}
