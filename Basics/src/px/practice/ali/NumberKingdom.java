package px.practice.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberKingdom {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long num = scanner.nextLong();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 64; i++) {
				if ((num & 1) == 1) {
					list.add(i);
				}
				num >>= 1;
			}
			long index = 0;
			for (int i = 0; i < list.size(); i++) {
				index += getBinomial(list.get(i), i+1);
			}
			System.out.println(index);
		}
		scanner.close();
	}
	
	private static long getBinomial(int sum, int select) {
		if (sum == 0) {
			return 0;
		}
		long result = 1;
		long divide = 1;
		for (int i = 1; i <= select; i++) {
			result *= sum-i+1;
			divide *= i;
			if (result % divide == 0) {
				result /= divide;
				divide = 1;
			}
		}
		return result/divide;
	}
}
