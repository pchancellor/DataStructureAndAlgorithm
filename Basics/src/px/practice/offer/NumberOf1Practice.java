package px.practice.offer;

public class NumberOf1Practice {
	
	public static void main(String[] args) {
		System.out.println(new NumberOf1Practice().NumberOf1(-3));
	}

    public int NumberOf1(int n) {
    	int num = 0;
    	for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) {
				num++;
			}
			n >>= 1;
		}
    	return num;
//    	return Integer.bitCount(n);
    }
}
