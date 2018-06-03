package px.practice.offer;

public class RotateArrayPractice {
	
	public int minNumberInRotateArraySimpleTraverse(int [] array) {
	    int min = array[0];
	    for (int i = 1; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}
	    return min;
    }

	public int minNumberInRotateArray(int [] array) {
		if (array.length == 0) {
			return 0;
		}
		int lastElem = array[array.length-1];
		if (lastElem > array[0]) {
			return array[0];
		}
		int start = 0;
		int end = array.length-1;
		while (start + 1 < end) {
			int midIndex = (start+end)/2;
			if (array[midIndex] > lastElem) {
				start = midIndex;
			} else {
				end = midIndex;
			}
		}
	    return Math.min(array[start], array[end]);
    }
	
}
