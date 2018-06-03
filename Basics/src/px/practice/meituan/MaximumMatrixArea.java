package px.practice.meituan;

import java.util.Scanner;

public class MaximumMatrixArea {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			int[] array = new int[num];
			for (int i = 0; i < array.length; i++) {
				array[i] = scanner.nextInt();
			}
			long maxArea = 0;
			for (int i = 0; i < num; i++) {
				maxArea = Math.max(maxArea, (findNext(array, i) - findPrev(array, i) + 1)*array[i]);
			}
			System.out.println(maxArea);
		}
		scanner.close();
	}

	public static int findPrev(int[] array, int index) {
		int i;
		for (i = index - 1; i >= 0; i--) {
			if (array[i] < array[index]) {
				break;
			}
		}
		return i+1;
	}

	public static int findNext(int[] array, int index) {
		int i;
		for (i = index + 1; i < array.length; i++) {
			if (array[i] < array[index]) {
				break;
			}
		}
		return i-1;
	}
}
