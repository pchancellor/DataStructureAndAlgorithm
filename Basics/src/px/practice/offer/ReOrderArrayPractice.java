package px.practice.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import px.practice.util.Utils;

public class ReOrderArrayPractice {
	
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = random.nextInt(100);
			list.add(arr[i]);
		}
		System.out.println(list);
//		new ReOrderArrayPractice().reOrderArray(arr);
		new ReOrderArrayPractice().reOrderArray2(arr);
		Utils.printArray(arr);
	}

    public void reOrderArray(int [] array) {
        int tmp, j ;
        for (int i = 1; i < array.length; i++) {
			if ((array[i] & 1) == 1) {
				tmp = array[i];
				j = i;
				while (--j >= 0) {
					if ((array[j] & 1) == 0) {
						array[j+1] = array[j];
					} else {
						break;
					}
				}
				array[j+1] = tmp;
			}
		}
    }

    /**
     * 空间换时间，另外使用一个数组保存结果
     * @param array
     */
    public void reOrderArray2(int [] array) {
    	int j = 0;
    	int[] array2 = new int[array.length];
    	for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
    	for (int i = 0; i < array2.length; i++) {
    		if ((array2[i] & 1) == 1) {
				array[j++] = array2[i];
			}
		}
    	for (int i = 0; i < array2.length; i++) {
    		if ((array2[i] & 1) == 0) {
				array[j++] = array2[i];
			}
		}
    }
}
