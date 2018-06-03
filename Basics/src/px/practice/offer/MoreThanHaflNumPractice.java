package px.practice.offer;

import java.util.Arrays;

public class MoreThanHaflNumPractice {

	public int MoreThanHalfNum_Solution(int [] array) {
		if (array.length == 0) {
			return 0;
		}
        Arrays.sort(array);
        int num = 1, tmpVal = array[0];
        for (int i = 1; i < array.length; i++) {
        	if (num > array.length/2) {
				return tmpVal;
			}
			if (array[i] == tmpVal) {
				num++;
			} else {
				tmpVal = array[i];
				num = 1;
			}
		}
        if (num > array.length/2) {
			return tmpVal;
		} else {
			return 0;
		}
    }
	
	/**
	 * 参考他人解法，时间复杂度O(n)
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution2(int [] array) {
		if (array.length == 0) {
			return 0;
		}
        int val = array[0], num = 1;
        for (int i = 1; i < array.length; i++) {
			if (array[i] == val) {
				num ++;
			} else if (num == 0) {
				val = array[i];
				num = 1;
			} else {
				num --;
			}
		}
        num = 0;
        for (int i = 0; i < array.length; i++) {
			if (array[i] == val) {
				num++;
			}
		}
        if (num > array.length/2) {
			return val;
		} else {
			return 0;
		}
    }
}
