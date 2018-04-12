package px.dp;

import java.util.Scanner;

public class UpStairs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int totalRows = scanner.nextInt();
			int[] stairs = new int[totalRows];
			for (int i = 0; i < stairs.length; i++) {
				stairs[i] = scanner.nextInt();
			}
			for (int i = 0; i < stairs.length; i++) {
				if (stairs[i] == 1) {
					System.out.println(0);
				} else if (stairs[i] == 2) {
					System.out.println(1);
				} else if (stairs[i] == 3) {
					System.out.println(2);
				} else {
					int[] totalMethods = new int[stairs[i]-1];
					totalMethods[0] = 1;
					totalMethods[1] = 2;
					for (int j = 2; j < totalMethods.length; j++) {
						totalMethods[j] = totalMethods[j-1] + totalMethods[j-2];
					}
					System.out.println(totalMethods[totalMethods.length-1]);
				}
			}
		}
	}

}
