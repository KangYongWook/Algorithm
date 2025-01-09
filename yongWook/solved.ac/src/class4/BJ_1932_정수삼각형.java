package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_1932_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int tria[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = st.countTokens();
			for (int j = 0; j < count; j++) {
				tria[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dp[][] = new int[N][N]; //최대값을 저장하는 배열
		
		dp[0][0] = tria[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
					
				if( j-1 >= 0 && dp[i-1][j] < dp[i-1][j -1]) {
					dp[i][j] = dp[i-1][j-1] + tria[i][j];
				}
				else {
					dp[i][j] = dp[i-1][j] + tria[i][j];
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print( dp[i][j] + " " );
//			}
//			System.out.println();
//		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max( result, dp[N-1][i] );
		}
		System.out.println(result);
		
	}
}
