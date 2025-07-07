package class4_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB°Å¸® {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][3];
		int dp[][] = new int[N][3];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//dp
		dp[0][0] =  arr[0][0];
		dp[0][1] =	arr[0][1];
		dp[0][2] =	arr[0][2];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0) {
					dp[i][j] = Math.min( dp[i-1][j+1] + arr[i][j], dp[i-1][j+2] + arr[i][j] );
				}
				else if(j == 1) {
					dp[i][j] = Math.min( dp[i-1][j+1] + arr[i][j], dp[i-1][j-1] + arr[i][j] );
				}
				else{
					dp[i][j] = Math.min( dp[i-1][j-1] + arr[i][j], dp[i-1][j-2] + arr[i][j] );
				}
			}
		}
		
		//dp log
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(dp[i][j]+ " " );
			}
			System.out.println();
		}
		
		int minNumber = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(dp[N-1][i] < minNumber) {
				minNumber = dp[N-1][i]; 
			}
		}
		
		System.out.println(minNumber);
	}
}
