package px.practice.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class DifferenceComputation {
	
	public static final int CUTOFF = 10;

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while (scanner.hasNext()) {
//			int numbers = scanner.nextInt();
//			int[] elems = new int[numbers];
//			for (int i = 0; i < elems.length; i++) {
//				elems[i] = scanner.nextInt();
//			}
//			computeDifference(elems);
//		}
//		scanner.close();
		
		testQuickSort();
	}
	
	public static void computeDifference(int[] array) {
		quicksort(array, 0, array.length-1);
		int minNums = 0, maxNums = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[0]) {
				minNums = i;
				break;
			}
		}
		for (int i = array.length-2; i >=0 ; i--) {
			if (array[i] != array[array.length-1]) {
				maxNums = array.length-1-i;
				break;
			}
		}
		int largest = minNums*maxNums;
		Map<Integer, Integer> smallestDMap = new HashMap<>();
		int[] array_diff = new int[array.length-1];
		boolean useMap = false;
		for (int i = 0; i < array_diff.length; i++) {
			if (useMap) {
				if (array[i+1] == array[i]) {
					smallestDMap.put(array[i], smallestDMap.get(array[i])==null?1:smallestDMap.get(array[i])+1);
				}
			} else {
				array_diff[i] = array[i+1] - array[i];
				if (array_diff[i] == 0) {
					useMap = true;
					smallestDMap.put(array[i], 1);
				}
			}
		}
		int smallest = 0;
		if (useMap) {
			for (int i : smallestDMap.values()) {
				smallest += (i+1)*i/2;
			}
		} else {
			quicksort(array_diff, 0, array_diff.length-1);
			for (int i = 1; i < array_diff.length; i++) {
				if (array_diff[i] != array_diff[0]) {
					smallest = i;
					break;
				}
				if (i == array_diff.length-1) {
					smallest = i+1;
				}
			}
		}
		System.out.println(smallest + " " + largest);
	}
	
	public static void quicksort(int[] array, int left, int right) {
		if (left + CUTOFF > right) {
			insertSort(array, left, right);
		} else {
			int pivot = findPivot(array, left, right);
			int i = left, j = right-1;
			for (;;) {
				//使用i++的结果就不对
				while (array[++i] < pivot) {}
				while (array[--j] > pivot) {}
				if (i<j) {
					swap(array, i, j);
				} else {
					break;
				}
			}
			swap(array, i, right-1);
			quicksort(array, left, i-1);
			quicksort(array, i+1, right);
		}
	}
	
	public static void insertSort(int[] array, int left, int right) {
		int j ;
		for (int i = left; i <= right; i++) {
			int val = array[i];
			for (j = i; j > 0 && array[j-1] > val; j--) {
				array[j] = array[j-1];
			}
			array[j] = val;
		}
	}
	
	public static void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	public static int findPivot(int[] array, int left, int right) {
		int middle = (left+right)/2;
		if (array[left] > array[middle]) {
			swap(array, left, middle);
		}
		if (array[left] > array[right]) {
			swap(array, left, right);
		}
		if (array[middle] > array[right]) {
			swap(array, right, middle);
		}
		swap(array, middle, right-1);
		return array[right-1];
	}
	
	public static void testQuickSort() {
		int[] arrays = new int[50];
		produceRandomArray(arrays);
//		quicksort(arrays, 0, arrays.length-1);
		computeDifference(arrays);
		for (int i : arrays) {
			System.out.print(i+" ");
		}
	}

	public static void produceRandomArray(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(30);
		}
		
//		for (int i = 0; i < array.length; i++) {
//			array[i] = i+1;
//		}
	}
	
}
