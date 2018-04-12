package px.practice.niuke;

public class FindSingleElem {

	/**
	 * 利用异或的性质：
	 * 1）异或运算满足交换律
	 * 2）相同的数异或的结果为0
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			res ^= A[i];
		}
		return res;
	}
	
	
}
