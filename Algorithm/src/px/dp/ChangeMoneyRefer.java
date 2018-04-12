package px.dp;

import java.util.Scanner;

public class ChangeMoneyRefer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int m=sc.nextInt();
			int[] v= {1,5,10,25,50};
			long[] dp=new long[m+1];
			dp[0]=1;
			for(int i=0;i<v.length;i++) {
				for(int j=1;j<=m;j++) {
					if(j>=v[i]) {
						dp[j]+=dp[j-v[i]];
					}
				}
			}
			System.out.println(dp[m]);
		}
	}
}
