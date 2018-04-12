package px.practice.tencent;

import java.util.Scanner;

public class CharRearrange {

	public static void main(String[] args) {
//		String target = args[0];
		Scanner scanner = new Scanner(System.in);
		String target = "AkleBiCeilD";
		while (scanner.hasNext()) {
			target = scanner.nextLine();
			System.out.println(swap(target));
		}
		scanner.close();
	}

	public static String swap(String target) {
		char[] array = target.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 'a') {
				swap(array, i);
			}
		}
		return new String(array);
	}
	
	public static boolean swap(char[] array, int index) {
		if (index >= array.length-1) {
			return false;
		}
		boolean swapped = true;
		if (array[index+1] < 'a') {
			swapped = swap(array, index+1);
		}
		if (swapped) {
			char tmp = array[index];
			array[index] = array[index+1];
			array[index+1] = tmp;
			return true;
		} else {
			return false;
		}
	}
}
