package px.practice.netease;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringRags {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String input = scanner.next();
			char[] chars = input.toCharArray();
			int pieceNum = 0;
			List<Integer> pieceLength = new ArrayList<>();
			char currentChar = 'A';
			int length = 0;
			for (char c : chars) {
				if (c == currentChar) {
					length ++ ;
				} else {
					if (currentChar != 'A') {
						pieceLength.add(length);
						pieceNum ++;
					}
					currentChar = c;
					length = 1;
				}
			}
			pieceLength.add(length);
			pieceNum ++;
			int sum = 0;
			for (Integer pLength : pieceLength) {
				sum += pLength;
			}
			DecimalFormat decimalFormat = new DecimalFormat(".00");
			System.out.println(decimalFormat.format(sum/(double)pieceNum));
		}
		scanner.close();
	}

}
