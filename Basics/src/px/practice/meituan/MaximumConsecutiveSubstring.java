package px.practice.meituan;

import java.util.Scanner;

public class MaximumConsecutiveSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String aString = scanner.nextLine();
			String bString = scanner.nextLine();
			int maxLength = 0;
			int fromIndex = 0;
			for (int i = 0; i < aString.length(); i++) {
				fromIndex = 0;
				int currentLength = 0;
				int index = bString.indexOf(aString.charAt(i), fromIndex);
				while (index != -1) {
					currentLength++;
					for (int j=i+1, k=index+1; j<aString.length() && k<bString.length(); j++,k++) {
						if (aString.charAt(j) != bString.charAt(k)) {
							break;
						}
						currentLength++;
					}
					maxLength = Math.max(maxLength, currentLength);
					index = bString.indexOf(aString.charAt(i), index+1);
					currentLength = 0;
				}
			}
			System.out.println(maxLength);
		}
		scanner.close();
	}

}
