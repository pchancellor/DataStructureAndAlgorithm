package px.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
//		int[] raw = new int[]{3,1,4,1,5,9,2,6,5};
		int[] raw = new int[]{203,39,186,207,83,80,89,237,247};
		System.out.println(findLongest(raw, raw.length));
	}

	public static int findLongest(int[] A, int n) {
        int[] subLength = new int[n];
        subLength[0] = 1;
        for (int i = 1; i < subLength.length; i++) {
        	subLength[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && subLength[j] + 1 > subLength[i]) {
					subLength[i] = subLength[j] + 1;
				}
			}
		}
        int maxLength = 0;
        for (int i = 0; i < subLength.length; i++) {
			maxLength = subLength[i] > maxLength ? subLength[i] : maxLength;
		}
        return maxLength;
    }
}
