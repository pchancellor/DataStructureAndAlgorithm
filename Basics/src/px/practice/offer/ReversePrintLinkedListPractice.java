package px.practice.offer;

import java.util.ArrayList;

import px.practice.util.ListNode;

public class ReversePrintLinkedListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
			list.add(0, listNode.val);
			listNode = listNode.next;
		}
        return list;
    }
}