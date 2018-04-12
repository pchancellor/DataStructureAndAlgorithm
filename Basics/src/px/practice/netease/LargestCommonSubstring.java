package px.practice.netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LargestCommonSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		Set<String> results = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			StringBuilder sBuilder = new StringBuilder(input);
			char c = input.charAt(i);
			sBuilder.deleteCharAt(i);
			for (int j = 0; j < input.length(); j++) {
				if (c == input.charAt(j)) {
					continue;
				}
				sBuilder.insert(j, c);
				if (isLegal(sBuilder.toString())) {
					results.add(sBuilder.toString());
				}
				sBuilder.deleteCharAt(j);
			}
		}
		System.out.println(results.size());
		scanner.close();
	}
	
	public static boolean isLegal(String string) {
		int leftBracket = 0, rightBracket = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '(') {
				leftBracket++ ;
			} else {
				rightBracket++ ;
			}
			if (rightBracket > leftBracket) {
				return false;
			}
		}
		return true;
	}

}
