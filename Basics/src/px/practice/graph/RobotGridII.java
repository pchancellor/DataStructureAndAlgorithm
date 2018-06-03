package px.practice.graph;

public class RobotGridII {

    public int countWays(int[][] map, int x, int y) {
    	if (x <= 0 || y <= 0) {
			return 0;
		} else if (x == 1 || y == 1) {
			return 1;
		} else {
			int[][] ways = new int[x][y];
			for (int i = 0; i < ways.length; i++) {
				if (map[i][0] != 1) {
					break;
				}
				ways[i][0] = 1;
			}
			for (int i = 0; i < ways[0].length; i++) {
				if (map[0][i] != 1) {
					break;
				}
				ways[0][i] = 1;
			}
			for (int i = 1; i < ways.length; i++) {
				for (int j = 1; j < ways[i].length; j++) {
					if (map[i][j] == 1) {
						ways[i][j] = (ways[i-1][j] + ways[i][j-1]) % 1000000007;
					}
				}
			}
			return ways[x-1][y-1];
		}
    }

    /**
     * 参考他人解法，进行局部性优化
     * @param map
     * @param x
     * @param y
     * @return
     */
    public int countWays2(int[][] map, int x, int y) {
    	if (x <= 0 || y <= 0) {
			return 0;
		} else if (x == 1 || y == 1) {
			return 1;
		} else {
			int[][] ways = new int[x][y];
			for (int i = 0; i < ways.length; i++) {
				for (int j = 0; j < ways[i].length; j++) {
					if (map[i][j] == 1) {
						if (i == 0 && j == 0) {
							ways[i][j] = 1;
						} else if (i == 0) {
							ways[i][j] = ways[i][j-1];
						} else if (j == 0) {
							ways[i][j] = ways[i-1][j];
						} else {
							ways[i][j] = (ways[i-1][j] + ways[i][j-1]) % 1000000007;
						}
					} else {
						ways[i][j] = 0;
					}
				}
			}
			return ways[x-1][y-1];
		}
    }
    
    /**
     * 递归方法
     * @deprecated 效率低，算不出来
     * @param map
     * @param x
     * @param y
     * @param xIndex
     * @param yIndex
     * @return
     */
    public int countWays(int[][] map, int x, int y, int xIndex, int yIndex) {
		if (xIndex == x-1) {
			for (int j = yIndex; j < y; j++) {
				if (map[xIndex][j] != 1) {
					return 0;
				}
			}
			return 1;
		}
		if (yIndex == y-1) {
			for (int i = xIndex; i < x; i++) {
				if (map[i][yIndex] != 1) {
					return 0;
				}
			}
			return 1;
		}
		if (map[xIndex+1][yIndex] == 1 && map[xIndex][yIndex+1] == 1) {
			return (countWays(map, x, y, xIndex+1, yIndex) + countWays(map, x, y, xIndex, yIndex+1)) % 1000000007;
		} else if (map[xIndex+1][yIndex] == 1) {
			return countWays(map, x, y, xIndex+1, yIndex);
		} else if (map[xIndex][yIndex+1] == 1) {
			return countWays(map, x, y, xIndex, yIndex+1);
		} else {
			return 0;
		}
	}
}
