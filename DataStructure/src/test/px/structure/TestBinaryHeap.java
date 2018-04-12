package test.px.structure;

import java.util.Random;

import px.structure.heap.BinaryHeap;

public class TestBinaryHeap {

	public static void main(String[] args) {
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(30);
		testInsert(binaryHeap);
		int size = binaryHeap.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(binaryHeap.deleteMin());
		}
	}

	public static void testInsert(BinaryHeap<Integer> binaryHeap) {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			binaryHeap.insert(random.nextInt(100));
		}
	}
	
}
