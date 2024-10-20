package class3_1;

import java.util.Scanner;

public class bj9461_파도반수열 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		long dp[] = new long[100];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1 ;
		for (int i = 3; i < 100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		for (int i = 0; i < t; i++) {
			System.out.println(dp[sc.nextInt()-1]);
		}
		
	}
}
