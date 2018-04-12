package px.practice.netease;

import java.util.Scanner;

public class OppositeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int number = scanner.nextInt();
			char[] chars = String.valueOf(number).toCharArray();
			StringBuilder sBuilder = new StringBuilder();
			for (int i = chars.length-1; i >= 0 ; i--) {
				sBuilder.append(chars[i]);
			}
			int result = number + Integer.valueOf(sBuilder.toString());
			System.out.println(result);
		}
		scanner.close();
	}

}
