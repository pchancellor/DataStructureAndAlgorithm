package px.practice.netease;

import java.util.Scanner;

public class Chorus_dp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arrayNum = scanner.nextInt();
		int[] arrays = new int[arrayNum];
		for (int i = 0; i < arrayNum; i++) {
			arrays[i] = scanner.nextInt();
		}
		
		
		scanner.close();
	}

}
