package px.practice.offer;

public class FibonacciArrayPractice {

	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] array = new int[n];
		array[0] = array[1] = 1;
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n-1];
    }
	
	public static void main(String[] args) {
		System.out.println(new FibonacciArrayPractice().FibonacciSaveSpace(5));
	}
	
	public int FibonacciSaveSpace(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int a1=1, a2=1;
		int res = a2;
		while (n-- > 2) {
			res = a2 + a1;
			a1 = a2;
			a2 = res;
		}
		return res;
    }
}
