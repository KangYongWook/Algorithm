package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		//입력
		int map[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dp[][] = new int[N][N];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0) {
					if(dp[i-1][j+1] < dp[i-1][j+2]) {
						dp[i][j] = map[i][j] + dp[i-1][j+1];
					}
					else {
						dp[i][j] = map[i][j] + dp[i-1][j+2];
					}
				}else if( j == 1) {
					if(dp[i-1][j-1] < dp[i-1][j+1]) {
						dp[i][j] = map[i][j] + dp[i-1][j-1];
					}
					else {
						dp[i][j] = map[i][j] + dp[i-1][j+1];
					}
				}else {
					if(dp[i-1][j-1] < dp[i-1][j-2]) {
						dp[i][j] = map[i][j] + dp[i-1][j-1];
					}
					else {
						dp[i][j] = map[i][j] + dp[i-1][j-2];
					}
				}
			}
		}
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print( dp[i][j] + " " );
//			}
//			System.out.println();
//		}
		
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Math.min( result, dp[N-1][i] );
		}
		System.out.println(result);
		
		
	}
}
