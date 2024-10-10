package class3_1;

import java.util.Scanner;

public class bj2579_계단오르기 {
	static int arr[];
	static int dp[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int t = sc.nextInt();
		dp = new int[301];
		arr = new int[301];
		for (int i = 0; i < t; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		//dp[] 항상 최대값 << 관점을 도착지점에서 관점을 보는거지
		//도착지점 -2dp  dp-3+ arr-1
		
		
		_dp(t);
		System.out.println(dp[t-1]);
	}
	
	public static void _dp(int t) {
		
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(arr[0],arr[1]) +arr[2];
		for (int i = 3; i < t; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}
	}
}
