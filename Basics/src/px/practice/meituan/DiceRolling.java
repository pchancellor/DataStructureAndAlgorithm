package px.practice.meituan;

import java.util.Scanner;

public class DiceRolling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int point = scanner.nextInt();
			int[] methods = new int[point+1];
			methods[0] = 1;
			for (int i = 1; i < methods.length; i++) {
				for (int j = 0; j < i; j++) {
					methods[i] += methods[j];
				}
			}
			System.out.println(methods[point]);
		}
		scanner.close();
	}

}
