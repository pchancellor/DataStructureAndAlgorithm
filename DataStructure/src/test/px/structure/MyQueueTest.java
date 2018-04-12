package test.px.structure;

import px.structure.list.MyArrayQueue;
import px.structure.list.MyDoubleLinkedListQueue;
import px.structure.list.MySingleLinkedListQueue;

public class MyQueueTest {

	public static void main(String[] args) {
//		testDoubleLinkedListQueue();
//		testSingleLinkedListQueue();
		testArrayQueue();
	}

	public static void testDoubleLinkedListQueue() {
		MyDoubleLinkedListQueue<Integer> queue = new MyDoubleLinkedListQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.dequeue());
		}
	}

	public static void testSingleLinkedListQueue() {
		MySingleLinkedListQueue<Integer> queue = new MySingleLinkedListQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.dequeue());
		}
	}

	public static void testArrayQueue() {
		MyArrayQueue<Integer> queue = new MyArrayQueue<>();
		for (int i = 0; i < 15; i++) {
			queue.enqueue(i);
		}
		System.out.println(queue.getSize());
		for (int i = 0; i < 15; i++) {
			System.out.println(queue.dequeue());
		}
	}
	
}
