package px.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
//		String aString = "1A2C3D4B56";//
//		String bString = "B1D23CA45B6A";//
		String aString = "rsymsknwbiapzhuoeyhjubogitoqfkswhbqhwqzyjuvdlzjlhlaubecnkzgvurdsuvqghpjazgxvue";
		String bString = "sclzdzbtrrkdybusjyjrszzqaebkpdtqnqadndvkenqirqqsplmceuuzhukcxxnkcyyvucqjlkysfarxkulpayvtwfmfaqpikzdslpklomafvtesecxygahwnyljldutzsoywiwkugerfbfefcqfvcrzcvbevufzbkbhfeshhdasqo";
		int[][] path = new int[aString.length()][bString.length()];
		System.out.println(new LongestCommonSubsequence().findLCS(aString, aString.length(), bString, bString.length(), path));
		StringBuilder sBuilder = new StringBuilder();
		int i = aString.length()-1;
		int j = bString.length()-1;
		while (i >= 0 && j >= 0) {
			if (path[i][j] == 1) {
				sBuilder.insert(0, aString.charAt(i));
				i--;
				j--;
			} else if (path[i][j] == 2) {
				j--;
			} else {
				i--;
			}
		}
		System.out.println(sBuilder.toString());
	}

	//path数组，1表示左上，2表示上，3表示左
	public int findLCS(String A, int n, String B, int m, int[][] path) {
        int[][] length = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
			length[i][0] = 0;
		}
        for (int i = 1; i < m; i++) {
			length[0][i] = 0;
		}
        for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i-1) == B.charAt(j-1)) {
					length[i][j] = length[i-1][j-1] + 1;
					path[i-1][j-1] = 1;
				} else {
					if (length[i][j-1] > length[i-1][j]) {
						length[i][j] = length[i][j-1];
						path[i-1][j-1] = 2;
					} else {
						length[i][j] = length[i-1][j];
						path[i-1][j-1] = 3;
					}
				}
			}
		}
        return length[n][m];
    }
	
	public int max(int a, int b) {
		return a > b ? a : b;
	}
}
