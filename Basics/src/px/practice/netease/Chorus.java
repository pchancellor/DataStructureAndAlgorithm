package px.practice.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 贪婪算法，局部最优，非全局最优
 * @author WD
 *
 */
public class Chorus {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arrayNum = scanner.nextInt();
		int[] arrays = new int[arrayNum];
		for (int i = 0; i < arrayNum; i++) {
			arrays[i] = scanner.nextInt();
		}
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(arrays[0]);
		int a1 = arrays[0];
		int a2 = -1;
		for (int i = 1; i < arrays.length; i++) {
			if (a2 == -1) {
				if (a1 == arrays[i] || (i+1 < arrays.length && Math.abs(arrays[i+1] - arrays[i]) > Math.abs(arrays[i] - arrays[i-1]))) {
					list1.add(arrays[i]);
					a1 = arrays[i];
				} else {
					list2.add(arrays[i]);
					a2 = arrays[i];
				}
			} else {
				if (Math.abs(arrays[i] - a1) > Math.abs(arrays[i] - a2)) {
					list2.add(arrays[i]);
					a2 = arrays[i];
				} else {
					list1.add(arrays[i]);
					a1 = arrays[i];
				}
			}
		}
		System.out.println(computeDifference(list1)+computeDifference(list2));
		scanner.close();
	}
	
	public static int computeDifference(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size()-1; i++) {
			sum += Math.abs(list.get(i+1)-list.get(i));
		}
		return sum;
	}

}
