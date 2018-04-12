package px.sort;

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
		for (int i : tempArray) {
			System.out.println(i);
		}
		return tempArray[k-1];
	}
	
}
