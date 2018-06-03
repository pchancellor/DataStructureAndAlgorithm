package test.px.structure;

import java.util.Random;

import px.structure.heap.LeftistHeap;

public class TestLeftistHeap {

	public static void main(String[] args) {
//		testPrint();
		testCopy();
//		testMerge();
//		testMergeSimple();
	}
	
	public static void testPrint() {
		Random random = new Random();
		LeftistHeap<Integer> heap = new LeftistHeap<>();
		for (int i = 0; i < 5; i++) {
			heap.insert(random.nextInt(100));
		}
		heap.printHeap();
	}
	
	public static void testCopy() {
		Random random = new Random();
		LeftistHeap<Integer> heap = new LeftistHeap<>();
		for (int i = 0; i < 5; i++) {
			heap.insert(random.nextInt(100));
		}
		heap.printHeap();
		LeftistHeap<Integer> heapCopy = new LeftistHeap<>();
		heap.copyTo(heapCopy);
		heapCopy.printHeap();
		while (!heap.isEmpty()) {
//			System.out.print(heap.deleteMin() + " ");
			heap.deleteMin();
			heap.printHeap();
			heapCopy.printHeap();
		}
		System.out.println();
		heapCopy.printHeap();
	}
	
	public static void testMergeSimple() {
		Random random = new Random();
		LeftistHeap<Integer> heap = new LeftistHeap<>();
		LeftistHeap<Integer> otherHeap = new LeftistHeap<>();
		for (int i = 0; i < 5; i++) {
			heap.insert(random.nextInt(100));
			otherHeap.insert(random.nextInt(100));
		}
		heap.printHeap();
		otherHeap.printHeap();
		heap.merge(otherHeap);
		heap.printHeap();
	}

	public static void testMerge() {
		Random random = new Random();
		LeftistHeap<Integer> heap = new LeftistHeap<>();
		LeftistHeap<Integer> otherHeap = new LeftistHeap<>();
		for (int i = 0; i < 5; i++) {
			heap.insert(random.nextInt(100));
			otherHeap.insert(random.nextInt(100));
		}
		heap.printHeap();
		otherHeap.printHeap();
		LeftistHeap<Integer> heapCopy = new LeftistHeap<>();
		LeftistHeap<Integer> otherHeapCopy = new LeftistHeap<>();
		otherHeap.copyTo(otherHeapCopy);
		heap.copyTo(heapCopy);
		System.out.println("heap:");
		while (!heap.isEmpty()) {
			System.out.print(heap.deleteMin() + " ");
		}
		System.out.println("\nother heap:");
		while (!otherHeap.isEmpty()) {
			System.out.print(otherHeap.deleteMin() + " ");
		}
		heapCopy.merge(otherHeapCopy);
		System.out.println();
		heapCopy.printHeap();
		System.out.println("\nmerged heap:");
		while (!heapCopy.isEmpty()) {
			System.out.print(heapCopy.deleteMin() + " ");
		}
	}
}
