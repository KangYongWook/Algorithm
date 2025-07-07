package class4_1;

import java.util.Iterator;
import java.util.Scanner;

public class BJ_11053_가장긴증가하는부분수열 {
	
	static int dp[];
	static int arr[];
	static int result = 0 ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			_dp(i);
		}
		
		System.out.println(result);
	}
	
	static void _dp(int point) {
		
		dp[point] = 1;
		
		for (int i = 0; i < point; i++) {
			if(arr[i] < arr[point]) {
				dp[point] = Math.max( dp[i] + 1 , dp[point]);
			}
		}
		result = Math.max(dp[point], result);
	}
}
