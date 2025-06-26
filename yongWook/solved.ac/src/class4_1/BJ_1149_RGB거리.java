package class4_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB°Å¸® {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][3];
		int dp[] = new int[N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//dp
		for (int i = 0; i < 3; i++) {
			dp[0]
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				
					if(j == 0) {
						dp[i] = Math.min( arr[i][j] + arr[i+1][j+1], arr[i][j] + arr[i+1][j+2] );
					}
					else if(j == 1) {
						dp[i] = Math.min( arr[i][j] + arr[i+1][j-1], arr[i][j] + arr[i+1][j+1] );
					}
					else {
						dp[i] = Math.min( arr[i][j] + arr[i+1][j-1], arr[i][j] + arr[i+1][j-2] );
					}
			}
		}
				
		System.out.println(dp[N-1]);
		
		
		
		
		
		
	}
}
