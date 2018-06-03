package px.practice.offer;

import px.practice.util.RandomListNode;
import px.practice.util.Utils;

public class RandomListCopyPractice {
	
	public static void main(String[] args) {
		//1,2,3,4,5,3,5,#,2,#
		RandomListNode phead = new RandomListNode(1), tmp = phead, random = phead;
		int[] labels = new int[] {1,2,3,4,5,3,5,2};
		for (int i = 1; i < labels.length; i++) {
			tmp.next = new RandomListNode(labels[i]);
			tmp = tmp.next;
			tmp.random = random;
			random = random.next;
		}
		phead.random = random;
		Utils.printList(phead);
		System.out.println();
		Utils.printList(Clone2(phead));
	}
	
	public static RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
        RandomListNode copiedHead = new RandomListNode(pHead.label), tmpCopied = copiedHead;
        RandomListNode tmp = pHead.next, cursor, copiedCursor;
        while (tmp != null) {
        	tmpCopied.next = new RandomListNode(tmp.label);
        	tmpCopied = tmpCopied.next;
        	tmp = tmp.next;
		}
        tmp = pHead;
        tmpCopied = copiedHead;
        while (tmp != null) {
        	copiedCursor = null;
        	if (tmp.random != null) {
            	cursor = pHead;
            	copiedCursor = copiedHead;
    			while (tmp.random != cursor) {
    				cursor = cursor.next;
    				copiedCursor = copiedCursor.next;
    			}
			}
			tmpCopied.random = copiedCursor;
			tmp = tmp.next;
			tmpCopied = tmpCopied.next;
		}
        return copiedHead;
    }

	/**
	 * 参考他人的方法
	 * @param pHead
	 * @return
	 */
	public static RandomListNode Clone2(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		RandomListNode tmp = pHead, next;
		while (tmp != null) {
			RandomListNode node = new RandomListNode(tmp.label);
			next = tmp.next;
			tmp.next = node;
			node.next = next;
			tmp = next;
		}
		tmp = pHead;
		while (tmp != null) {
			if (tmp.random != null) {
				tmp.next.random = tmp.random.next;
			}
			tmp = tmp.next.next;
		}
        RandomListNode copiedHead = pHead.next, copiedTmp = copiedHead;
        pHead.next = copiedTmp.next;
        copiedTmp.next = null;
		tmp = pHead.next;
		while (tmp != null) {
			copiedTmp.next = tmp.next;
			copiedTmp = copiedTmp.next;
			tmp.next = copiedTmp.next;
			tmp = tmp.next;
		}
        return copiedHead;
    }
}
