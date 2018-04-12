package px.practice.tencent;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PrimeNumberPair {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int target = scanner.nextInt();
			Set<Integer> primeSet = new TreeSet<>();
			primeSet.add(2);	primeSet.add(3);	primeSet.add(5);	primeSet.add(7);
			primeSet.add(11);	primeSet.add(13);
			for (int i = 17; i < target; i++) {
				if (i %2 == 0 || i%3 == 0 || i%5 == 0 || i%7 == 0 || i%11 == 0 || i%13 == 0) {
					continue;
				}
				int j ;
				for (j = 4; j < i; j++) {
					if (i%j==0) {
						break;
					}
				}
				if (j == i) {
					primeSet.add(i);
				}
			}
			int pairs = 0;
			for (Integer integer : primeSet) {
				if (integer <= target/2 && primeSet.contains(target - integer)) {
					pairs++;
				}
			}
			System.out.println(pairs);
		}
		scanner.close();
	}

}
