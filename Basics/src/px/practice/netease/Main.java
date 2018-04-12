package px.practice.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int number = scanner.nextInt();
			List<String> list = new ArrayList<>();
			record(number, list);
			for (String val : list) {
				System.out.print(val);
			}
			
		}
		scanner.close();
	}
	
	public static void record(int number, List<String> records) {
		if (number == 0) {
			return ;
		}
		if (number %2 == 0) {
			record((number-2)/2, records);
			records.add("2");
		} else {
			record((number-1)/2, records);
			records.add("1");
		}
	}

}
