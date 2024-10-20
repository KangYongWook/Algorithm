package class3_1;

import java.util.Scanner;

public class bj11727_2xn≈∏¿œ∏µ2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long dp[] = new long[1000];
		
		dp[0] = 1;
		dp[1] = 3;
		dp[2] = 5;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i-1] + dp[i-2] *2) % 10007;
		}
		
		System.out.println(dp[sc.nextInt()-1] );
		
	}
}

