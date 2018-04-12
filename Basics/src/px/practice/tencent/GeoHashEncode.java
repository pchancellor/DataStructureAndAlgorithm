package px.practice.tencent;

import java.util.Scanner;

public class GeoHashEncode {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int target = scanner.nextInt();
			int left = -90;
			int right = 90;
			int middle = 0;
			StringBuilder sBuilder = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				if (target >= middle) {
					sBuilder.append(1);
					left = middle;
				} else {
					sBuilder.append(0);
					right = middle;
				}
				middle = (left + right) / 2;
			}
			System.out.println(sBuilder.toString());
		}
		scanner.close();
	}
}
