package px.sort;

import px.structure.heap.BinaryHeap;

/**
 * ∞¥…˝–Ú≈≈¡–
 * @author WD
 *
 */
public class SortUtil {
	
	/**
	 * œ£∂˚≈≈–Ú ˝◊È
	 */
	private static final int[] SHELL_ARRAY = new int[] {1, 5, 19, 41, 109};
	/**
	 * øÏÀŸ≈≈–ÚΩÿ÷π∑∂Œß
	 */
	private static final int CUT_OFF = 10;

	public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a) {
		insertionSort(a, 0, a.length-1);
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a, int left, int right) {
		int j ;
		for (int i = left; i <= right; i++) {
			AnyType tmp = a[i];
			for (j = i-1; j >= left; j--) {
				if (a[j].compareTo(tmp) <= 0) {
					break;
				}
				a[j+1] = a[j];
			}
			a[j+1] = tmp;
		}
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a) {
		for (int i = SHELL_ARRAY.length-1; i >= 0; i--) {
			int interval = SHELL_ARRAY[i];
			for (int j = interval; j < a.length; j++) {
				int k;
				AnyType tmp = a[j];
				for (k = j-interval; k >= 0; k-=interval) {
					if (a[k].compareTo(tmp) <= 0) {
						break;
					}
					a[k+interval] = a[k];
				}
				a[k+interval] = tmp;
			}
		}
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a) {
		BinaryHeap<AnyType> heap = new BinaryHeap<>(a);
		for (int i = 0; i < a.length; i++) {
			a[i] = heap.deleteMin();
		}
	}

	@SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a) {
		AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length-1);
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right) {
		if (left == right) {
			return;
		}
		int middle = (left + right) / 2;
		mergeSort(a, tmpArray, left, middle);
		mergeSort(a, tmpArray, middle+1, right);
		int pos = left;
		int i, j;
		for (i = left, j = middle + 1; i <= middle && j <= right; ) {
			if (a[i].compareTo(a[j]) < 0) {
				tmpArray[pos++] = a[i++];
			} else {
				tmpArray[pos++] = a[j++];
			}
		}
		if (i > middle) {
			System.arraycopy(a, j, tmpArray, pos, right-j+1);
		} else {
			System.arraycopy(a, i, tmpArray, pos, middle-i+1);
		}
		System.arraycopy(tmpArray, left, a, left, right-left+1);
	}

	public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a) {
		quickSort(a, 0, a.length-1);
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a, int left, int right) {
		if (left + CUT_OFF > right) {
			insertionSort(a, left, right);
		} else {
			AnyType pivot = findPivot(a, left, (left+right)/2, right);
			int i = left, j = right - 1;
			while (i < j) {
				while (a[++i].compareTo(pivot)<0) {}
				while (a[--j].compareTo(pivot)>0) {}
				if (i < j) {
					swap(a, i, j);
				}
			}
			swap(a, i, right-1);
			quickSort(a, left, i-1);
			quickSort(a, i+1, right);
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>> AnyType findPivot(AnyType[] a, int left, int middle, int right) {
		if (a[left].compareTo(a[middle]) > 0) {
			swap(a, left, middle);
		}
		if (a[left].compareTo(a[right]) > 0) {
			swap(a, left, right);
		}
		if (a[middle].compareTo(a[right]) > 0) {
			swap(a, middle, right);
		}
		swap(a, middle, right-1);
		return a[right-1];
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void swap(AnyType[] a, int aIndex, int bIndex) {
		AnyType tmp = a[aIndex];
		a[aIndex] = a[bIndex];
		a[bIndex] = tmp;
	}

	public static void bucketSort(int[] a, int maxElem) {
		int[] bucket = new int[maxElem];
		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
		}
		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			while (bucket[i] > 0) {
				a[j++] = i;
				bucket[i]--;
			}
		}
	}

	public static <AnyType extends Comparable<? super AnyType>> void outerSort(AnyType[] a) {
		
	}
}
