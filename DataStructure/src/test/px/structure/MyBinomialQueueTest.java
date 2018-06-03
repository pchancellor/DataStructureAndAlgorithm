package test.px.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import px.structure.heap.BinomialQueue;

public class MyBinomialQueueTest {

	public static void main(String[] args) {
//		testInsert();
		testMerge();
	}

	public static void testInsert() {
		BinomialQueue<Integer> queue = new BinomialQueue<>();
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int num = random.nextInt(100);
			list.add(num);
			queue.insert(num);
		}
		System.out.println(list);
		System.out.println(queue.findMin());
		while (!queue.isEmpty()) {
			System.out.print(queue.deleteMin()+" ");
		}
	}
	
	public static void testMerge() {
		BinomialQueue<Integer> queue1 = new BinomialQueue<>();
		BinomialQueue<Integer> queue2 = new BinomialQueue<>();
		Random random = new Random();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int num = random.nextInt(100);
			list1.add(num);
			queue1.insert(num);
		}
		for (int i = 0; i < 10; i++) {
			int num = random.nextInt(100);
			list2.add(num);
			queue2.insert(num);
		}
		System.out.println(list1);
		System.out.println(list2);
		queue1.merge(queue2);
		System.out.println("queue1, size " + queue1.size());
		while (!queue1.isEmpty()) {
			System.out.print(queue1.deleteMin()+" ");
		}
		System.out.println("\nqueue2:");
		while (!queue2.isEmpty()) {
			System.out.print(queue2.deleteMin()+" ");
		}
	}
}
