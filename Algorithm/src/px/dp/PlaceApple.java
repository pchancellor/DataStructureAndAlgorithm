package px.dp;

import java.util.Scanner;

public class PlaceApple {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int appleNum = scanner.nextInt();
			int plateNum = scanner.nextInt();
			int[][] methods = new int[appleNum+1][plateNum+1];//盘子数不考虑为0
			for (int i = 1; i <= plateNum; i++) {//0个苹果，任意个盘子，放置的方法都是1
				methods[0][i] = methods[1][i] = 1;
			}
			for (int i = 1; i <= appleNum; i++) {
				methods[i][1] = 1;
			}
			for (int i = 2; i <= appleNum; i++) {
				for (int j = 2; j <= plateNum; j++) {
					methods[i][j] = i < j ? methods[i][j-1] : methods[i][j-1] + methods[i-j][j];
				}
			}
			System.out.println(methods[appleNum][plateNum]);
		}
	}

	public static void takeOrderIntoConsideration(int appleNum, int plateNum) {
		int[][] methods = new int[appleNum+1][plateNum+1];
		for (int i = 1; i <= plateNum; i++) {
			methods[0][i] = 1;
		}
		for (int i = 1; i <= appleNum; i++) {
			methods[i][1] = 1;
		}
		for (int j = 2; j <= plateNum; j++) {
			for (int i = 1; i <= appleNum; i++) {
				methods[i][j] = methods[i-1][j]+methods[i][j-1];
			}
		}
		System.out.println(methods[appleNum][plateNum]);
	}
	
}
