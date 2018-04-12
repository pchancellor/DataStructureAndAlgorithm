package px.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> payments = new ArrayList<>();
		int maxPay = 0;
		while (scanner.hasNext()) {
			int payment = scanner.nextInt();
			maxPay = Math.max(maxPay, payment);
			payments.add(payment);
		}
		long[][] methods = new long[maxPay+1][5];//5表示5种可以使用的货币
		int[] coins = new int[] {1,5,10,25,50};
		for (int coin = 0; coin < 5; coin++) {
			methods[0][coin] = 1;
		}
		for (int pay = 1; pay < methods.length; pay++) {
			methods[pay][0] = 1;
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < methods.length; j++) {
				for (int k = 0; k <= j/coins[i]; k++) {
					methods[j][i] += methods[j-coins[i]*(k)][i-1];
				}
			}
		}
		for (int i : payments) {
			System.out.println(methods[i][4]);
		}
		scanner.close();
	}
}
