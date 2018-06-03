package test.px.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import px.structure.heap.BinaryHeap;

public class TestBinaryHeap {

	public static void main(String[] args) {
		Random random = new Random();
		Integer[] array = new Integer[20];
		List<Integer> rawData = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int num = random.nextInt(100);
			array[i] = num;
			rawData.add(num);
		}
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(array);
		System.out.println("rawData:" + rawData);
		testSort(binaryHeap);
	}

	public static void test() {
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(30);
		testInsert(binaryHeap);
		testSort(binaryHeap);
	}
	
	public static void testInsert(BinaryHeap<Integer> binaryHeap) {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			binaryHeap.insert(random.nextInt(100));
		}
	}
	
	public static void testSort(BinaryHeap<Integer> binaryHeap) {
		int size = binaryHeap.size();
		for (int i = 0; i < size; i++) {
			System.out.print(binaryHeap.deleteMin() + " ");
		}
	}
}
