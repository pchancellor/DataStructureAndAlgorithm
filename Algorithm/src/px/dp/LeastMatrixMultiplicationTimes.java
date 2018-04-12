package px.dp;

public class LeastMatrixMultiplicationTimes {

	public static void main(String[] args) {
		int[] c = new int[]{50,10,40,30,5};
		long[][] m = new long[c.length][c.length];
		int[][] lastChange = new int[c.length][c.length];
		optMatrix(c, m, lastChange);
		System.out.println(m[1][m.length-1]);
		printMultiplicationTrace(lastChange, 1, m.length-1);
	}
	
	public static void optMatrix(int[] c, long[][] m, int[][] lastChange) {
		int n = c.length - 1;
		for (int i = 1; i <= n; i++) {
			m[i][i] = 0;
		}
		long count = 0;
		for (int k = 1; k < n; k++) {
			for (int start = 1; start <= n-k; start++) {
				int end = start + k;
				m[start][end] = Long.MAX_VALUE;
				for (int i = start; i < end; i++) {
					count = m[start][i] + m[i+1][end] + c[start-1]*c[i]*c[end];
					if (count < m[start][end]) {
						m[start][end] = count;
						lastChange[start][end] = i;
					}
				}
			}
		}
	}
	
	public static void printMultiplicationTrace(int[][] lastChange, int start, int end) {
		if (start == end) {
			return;
		}
		if (start+1<=end) {
			int i = lastChange[start][end];
			printMultiplicationTrace(lastChange, start, i);
			printMultiplicationTrace(lastChange, i+1, end);
		}
		System.out.println("matrix["+start+","+end+"]");
	}
}
