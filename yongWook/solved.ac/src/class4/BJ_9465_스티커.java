package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465_½ºÆ¼Ä¿ {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			
			int row = Integer.parseInt(br.readLine());
			int sticker[][] = new int[2][row];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < row; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for (int j = 0; j < 2; j++) {
//				for (int j2 = 0; j2 < row; j2++) {
//					System.out.print(sticker[j][j2] + " ");
//				}
//				System.out.println();
//			}
			
			int dp[][] = new int[2][row];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
				
			for (int k = 1; k < row; k++) {
				if( k == 1) {
					dp[0][k] = dp[1][k-1] + sticker[0][k];
					dp[1][k] = dp[0][k-1] + sticker[1][k];
				}else {
					dp[0][k] = Math.max( dp[1][k-1], dp[1][k-2]) + sticker[0][k];
					dp[1][k] = Math.max( dp[0][k-1], dp[0][k-2]) + sticker[1][k];
				}
			}
			
//			for (int j = 0; j < 2; j++) {
//				for (int j2 = 0; j2 < row; j2++) {
//					System.out.print(dp[j][j2] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.println(Math.max(dp[0][row-1], dp[1][row-1]));
		}
		
	}
}
