package px.structure.disjointset;

/**
 * ���ཻ���ࣨ���鼯��
 * @author WD
 *
 */
public class DisjointSet {

	private int[] s;
	
	public DisjointSet(int numElements) {
		s = new int[numElements];
		for (int i = 0; i < s.length; i++) {
			s[i] = -1;
		}
	}
	
	/**
	 * ���߶���
	 * @param root1
	 * @param root2
	 */
	public void union(int root1, int root2) {
		if (s[root1] < s[root2]) {
			s[root2] = root1;
		} else {
			if (s[root1] == s[root2]) {
				s[root2]--;
			}
			s[root1] = root2;
		}
	}
	
	/**
	 * ����С��
	 * @param root1
	 * @param root2
	 */
	public void unionByScale(int root1, int root2) {
		if (s[root1] < s[root2]) {
			s[root1] += s[root2];
			s[root2] = root1;
		} else {
			s[root2] += s[root1];
			s[root1] = root2;
		}
	}
	
	/**
	 * ���ҹ��̽���·��ѹ��
	 * @param val
	 * @return
	 */
	public int find(int val) {
		if (s[val] < 0) {
			return val;
		} else {
			return s[val] = find(s[val]);
		}
	}
	
}
