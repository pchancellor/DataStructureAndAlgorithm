package px.dp;

public class MonoSum {
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,5,2,4,6};
		System.out.println(new MonoSum().calcMonoSum(array, array.length));
	}
	
	public int calcMonoSum(int[] A, int n) {
        int[] count = new int[n];
        for (int i = 1; i < count.length; i++) {
        	for (int j = 0; j < i; j++) {
				if (A[j] <= A[i]) {
					count[j]++;
				}
			}
		}
        int monoSum = 0;
        for (int i = 0; i < count.length; i++) {
			monoSum += count[i]*A[i];
		}
        return monoSum;
    }
	
}
