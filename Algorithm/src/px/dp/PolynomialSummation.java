package px.dp;

public class PolynomialSummation {

	public static void main(String[] args) {
		int n = 10;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			System.out.println("eval1结果："+eval(n));
			System.out.println("eval时间：" + (System.currentTimeMillis() - startTime) + "ms");
			startTime = System.currentTimeMillis();
			System.out.println("eval2结果："+eval2(n));
			System.out.println("eval2时间：" + (System.currentTimeMillis() - startTime) + "ms");
			startTime = System.currentTimeMillis();
			n *= 10;
		}
	}
	
	//c(n)=2/n*(c(1)+c(2)+...+c(n-1))+n
	public static double eval(int n) {
		double[] c = new double[n+1];
		c[0] = 1.0;
		for (int i = 1; i <= n; i++) {
			c[i] = c[i-1] + 2 + (c[i-1]-1)/i;
		}
		return c[n];
	}
	
	public static double eval2(int n) {
		double[] c = new double[n+1];
		c[0] = 1.0;
		for (int i = 1; i <= n; i++) {
			double sum = 0.0;
			for (int j = 0; j < i; j++) {
				sum += c[j];
			}
			c[i] = 2.0*sum/i + i;
		}
		return c[n];
	}

}
