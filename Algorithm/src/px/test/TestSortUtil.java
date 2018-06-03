package px.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import px.sort.SortUtil;

public class TestSortUtil {

	@Test
	public void run() {
		Random random = new Random();
		Integer[] array = new Integer[200];
		List<Integer> rawData = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int num = random.nextInt(1000);
			array[i] = num;
			rawData.add(num);
		}
		int[] array2 = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
//		SortMethod method = SortMethod.insert;
//		SortMethod method = SortMethod.shell;
//		SortMethod method = SortMethod.heap;
//		SortMethod method = SortMethod.merge;
		SortMethod method = SortMethod.quick;
//		SortMethod method = SortMethod.bucket;
		switch (method) {
		case insert:
			SortUtil.insertionSort(array);
			break;
		case shell:
			SortUtil.shellSort(array);
			break;
		case heap:
			SortUtil.heapSort(array);
			break;			
		case merge:
			SortUtil.mergeSort(array);
			break;
		case quick:
			SortUtil.quickSort(array);
			break;
		case bucket:
			int max = array[0];
			for (int i = 1; i < array.length; i++) {
				max = Math.max(max, array[i]);
			}
			SortUtil.bucketSort(array2, max+1);
			break;
		case outer:
			SortUtil.outerSort(array);
			break;
		default:
			break;
		}
		System.out.println("rawData:" + rawData);
		if (method.equals(SortMethod.bucket)) {
			print(array2);
		} else {
			print(array);
		}
	}
	
	enum SortMethod {
		insert, shell, heap, merge, quick, bucket, outer
	}
	
	public <T> void print(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
