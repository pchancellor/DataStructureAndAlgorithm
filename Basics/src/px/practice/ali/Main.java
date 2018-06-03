package px.practice.ali;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int cash = scanner.nextInt();
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			int[][] passFee = new int[row][column];
			int[][] price = new int[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					passFee[i][j] = scanner.nextInt();
				}
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					price[i][j] = scanner.nextInt();
				}
			}
			int[][] carrying = new int[row][column];
			carrying[0][0] = cash;
			boolean carry = false;
			for (int i = 1; i < column; i++) {
				int diff ;
				if ((diff = carrying[0][i-1] + price[0][i] - price[0][i-1]) > 0) {
					carrying[0][i] += diff - passFee[0][i];
				} else {
					carrying[0][i] = carrying[0][i-1] - passFee[0][i];
				}
			}
			for (int i = 1; i < row; i++) {
				int diff ;
				if ((diff = carrying[i][0] + price[i][0] - price[i-1][0]) > 0) {
					carrying[i][0] += diff - passFee[i][0];
				} else {
					carrying[i][0] = carrying[i-1][0] - passFee[i][0];
				}
			}
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < column; j++) {
					if (carry) {
						int a = carrying[i][j-1] + price[i][j] - price[i][j-1];
						int b = carrying[i-1][j] + price[i][j] - price[i-1][j];
						int diff = Math.max(a, b);
						if (diff > 0) {
							carrying[i][j] += diff - passFee[i][j];
						} else {
							carrying[i][j] += Math.max(carrying[i][j-1], carrying[i-1][j]) - passFee[i][j];
						}
					} else {
						
					}
				}
			}
			System.out.println(carrying[row-1][column-1]);
		}
	}
	
	public static void dp() {
		
	}

}
