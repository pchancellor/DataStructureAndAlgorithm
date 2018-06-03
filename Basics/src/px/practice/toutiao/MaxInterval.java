package px.practice.toutiao;

import java.util.Scanner;

public class MaxInterval {

	//81 87 47 59 81 18 25 40 56 0 
	//
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			int[] array = new int[num];
			for (int i = 0; i < array.length; i++) {
				array[i] = scanner.nextInt();
			}
			long[] sum = new long[num];
			for (int i = 0; i < sum.length; i++) {
				int left = i, right = i+1;
				for (; right < sum.length; right++) {
					if (array[right] >= array[i]) {
						sum[i] += array[right];
					} else {
						break;
					}
				}
				for (; left >= 0; left--) {
					if (array[left] >= array[i]) {
						sum[i] += array[left];
					} else {
						break;
					}
				}
				sum[i] *= array[i];
			}
			long maxVal = sum[0];
			for (int i = 1; i < sum.length; i++) {
				maxVal = maxVal >= sum[i] ? maxVal : sum[i];
			}
			System.out.println(maxVal);
		}
		scanner.close();
	}

}
