package px.util;

public class ArrayUtil {

	public static void swapTwoValues(int[] array, int index1, int index2) throws Exception {
		if (index1 >= array.length || index1 < 0 || index2 >= array.length || index2 < 0) {
			throw new Exception("index out of boundary");
		}
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}
