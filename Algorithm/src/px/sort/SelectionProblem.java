package px.sort;

import px.structure.heap.BinaryHeap;
import px.util.ArrayUtil;

public class SelectionProblem {

	public int selectKBiggestValue (int[] arrays, int k) throws Exception {
		int[] tempArray = new int[k];
		for (int i = 0; i < k; i++) {
			tempArray[i] = arrays[i];
			for (int j = i - 1; j >= 0; j--) {
				if (tempArray[j] >= tempArray[j+1]) {
					break;
				}
				ArrayUtil.swapTwoValues(tempArray, j, j+1);
			}
		}
		for (int i = k; i < arrays.length; i++) {
			if (tempArray[k-1] >= arrays[i]) {
				continue;
			}
			tempArray[k-1] = arrays[i];
			for (int j = k-1; j > 0; j--) {
				if (tempArray[j-1] >= tempArray[j]) {
					break;
				}
				ArrayUtil.swapTwoValues(tempArray, j-1, j);
			}
		}
		return tempArray[k-1];
	}
	
	public int selectKthBiggestValueUsingHeap(int[] array, int k) {
		Integer[] array2 = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(array2);
		for (int i = 0; i < k-1; i++) {
			binaryHeap.deleteMin();
		}
		return binaryHeap.deleteMin();
	}

	public int selectKthBiggestValueUsingHeapSizeK(int[] array, int k) {
		Integer[] array2 = new Integer[k];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = array[i];
		}
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(array2);
		for (int i = array2.length; i < array.length; i++) {
			if (array[i] > binaryHeap.findMin()) {
				binaryHeap.replaceMin(array[i]);
			}
		}
		return binaryHeap.findMin();
	}
	
}
