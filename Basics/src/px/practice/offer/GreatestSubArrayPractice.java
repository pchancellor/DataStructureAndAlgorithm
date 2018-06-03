package px.practice.offer;

public class GreatestSubArrayPractice {
	
	public static void main(String[] args) {
//		int[] arr = new int[] {6,-3,-2,7,-15,1,2,2};
//		int[] arr = new int[] {-2,-8,-1,-5,-9};
		int[] arr = new int[] {-3, -2, -3, -10, -4, -7, -2, -5};//
		
		System.out.println(new GreatestSubArrayPractice().FindGreatestSumOfSubArray(arr));
	}

    public int FindGreatestSumOfSubArray(int[] array) {
    	int max = array[0], sum = 0;
    	for (int i = 0; i < array.length; i++) {
			sum += array[i];
			max = max > sum ? max : sum;
			if (sum < 0) {
				sum = 0;
			}
		}
    	return max;
    }
}
