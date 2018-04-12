package px.binarysearch;

public class CountAppearance {

	public static void main(String[] args) {
		int[] array = new int[] {4,4,4,4,4,4,4,4,4,4,4,4};
//		int[] array = new int[] {1,2,3,4,4,4,4,6,8,9};
		int num = 4;
		int left = findPos(array, num, true);
		int right = findPos(array, num, false);
		if (left == -1 || right == -1) {
			System.out.println("not found");
		} else {
			System.out.println("appearance counts:" + (right - left + 1));
		}
	}

	public static int findPos(int[] array, int target, boolean isLeft) {
		int left = 0, right = array.length - 1;
		int pos = -1, mid ;
		while (left <= right) {
			mid = (left + right) / 2;
			if (array[mid] < target) {
				left = mid + 1;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				pos = mid;
				if (isLeft) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return pos;
	}
	
}
