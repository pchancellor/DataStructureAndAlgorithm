package px.practice.graph;

public class RobotGridI {
	
	public static void main(String[] args) {
		System.out.println(new RobotGridI().yanghuiTriangle(6, 6));
	}

    public int countWays(int x, int y) {
        return yanghuiTriangle(x+y-2, x-1);
    }
    
    /**
     * 通过杨辉三角计算二项系数
     * @param total
     * @param select
     * @return
     */
    public int yanghuiTriangle(int total, int select) {
		int[][] elems = new int[total+1][total+1];
		for (int i = 0; i <= total; i++) {
			elems[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				if (j == i) {
					elems[i][j] = 1;
				} else {
					elems[i][j] = elems[i-1][j] + elems[i-1][j-1];
				}
			}
		}
		return elems[total][select];
	}
}
