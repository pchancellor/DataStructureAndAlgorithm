package px.practice.meituan;

import java.util.Scanner;

public class MoneyComposition {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] currency = new int[]{1,5,10,20,50,100};
		while (scanner.hasNext()) {
			int money = scanner.nextInt();
			long[][] methods = new long[money+1][currency.length];
			for (int i = 0; i < methods.length; i++) {
				methods[i][0] = 1;
			}
			for (int i = 0; i < currency.length; i++) {
				methods[0][i] = 1;
			}
			for (int i = 1; i < currency.length; i++) {
				for (int j = 1; j < methods.length; j++) {
					for (int k = 0; k*currency[i] <= j; k++) {
						methods[j][i] += methods[j-k*currency[i]][i-1];
					}
				}
			}
			System.out.println(methods[money][currency.length-1]);
		}
		scanner.close();
	}
}
