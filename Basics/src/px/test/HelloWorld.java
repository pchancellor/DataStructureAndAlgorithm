package px.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class HelloWorld {

	public static void main(String[] args) {
//		long val = (long) Math.pow(2, 66);
		

		long epoch = 1522734894012l;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(epoch);
		System.out.println(calendar.getTime());
		
	}
	
	public static void hello() {
		int[] array = new int[10];
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			array[i] = random.nextInt(100);
		}
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
