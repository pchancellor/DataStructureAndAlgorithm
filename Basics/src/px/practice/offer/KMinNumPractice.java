package px.practice.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KMinNumPractice {
	
	public static void main(String[] args) {
		int[] arr = new int[] {4,5,1,6,2,7,3,8};
		System.out.println(new KMinNumPractice().GetLeastNumbers_Solution(arr, 10));
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if (input.length < k || k == 0) {
			return list;
		}
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(k, (o1, o2) ->  o2.compareTo(o1));
		for (int i = 0; i < k; i++) {
			pQueue.add(input[i]);
		}
		for (int i = k; i < input.length; i++) {
			if (input[i] < pQueue.peek()) {
				pQueue.poll();
				pQueue.add(input[i]);
			}
		}
		while (!pQueue.isEmpty()) {
			list.add(0, pQueue.poll());
		}
		return list;
    }
}
