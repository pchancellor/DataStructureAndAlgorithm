package px.practice.niuke;

public class FindSingleElem {

	/**
	 * �����������ʣ�
	 * 1������������㽻����
	 * 2����ͬ�������Ľ��Ϊ0
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
