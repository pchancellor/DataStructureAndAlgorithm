package px.practice.netease;

import java.util.Scanner;

public class FourTimesArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arrayNum = scanner.nextInt();
		int[][] arrays = new int[arrayNum][];
		for (int i = 0; i < arrayNum; i++) {
			int elemNum = scanner.nextInt();
			int[] elems = new int[elemNum];
			for (int j = 0; j < elems.length; j++) {
				elems[j] = scanner.nextInt();
			}
			arrays[i] = elems;
		}
		for (int[] elems : arrays) {
			int elemNum = elems.length;
			int oddNum = 0;
			int fourTimesNum = 0;
			for (int elem : elems) {
				if (elem % 2 == 1) {
					oddNum ++ ;
				} else if (elem % 4 == 0) {
					fourTimesNum ++ ;
				}
			}
			if (elemNum % 2 == 0) {
				if (oddNum > elemNum/2.0) {
					System.out.println("No");
				} else if (oddNum > fourTimesNum ) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			} else {
				if (oddNum > elemNum/2.0+1) {
					System.out.println("No");
				} else if (oddNum > fourTimesNum + 1 ) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			}
		}
		scanner.close();
	}
}
