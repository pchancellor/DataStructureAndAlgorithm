package test.px.structure;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			queue.add(random.nextInt(10));
		}
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			System.out.println(queue.poll());
		}
	}

}
