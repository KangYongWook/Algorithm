package class4;
import java.util.Scanner;

public class BJ_11053_가장긴증가하는부분수열 {
	static int arr[];
	static int dp[];
	static int result;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// 입력
		arr = new int[t];
		dp = new int[t];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		//dp시작
		result = 0;
		for (int i = 0; i < t; i++) { 
			_dp(i);
		}

		System.out.println(result);

	}

	private static void _dp(int end) {
		
		dp[end] = 1; //반드시 1  최악의 부분수열은 1 << 
		for (int i = 0; i < end; i++) {
			if(arr[i] < arr[end]) {
				dp[end] = Math.max(dp[i] + 1, dp[end]);
			}
		}
		result = Math.max(result,  dp[end]);
		
	}
}
