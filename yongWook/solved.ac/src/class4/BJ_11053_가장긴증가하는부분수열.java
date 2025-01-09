package class4;
import java.util.Scanner;

public class BJ_11053_����������ϴºκм��� {
	static int arr[];
	static int dp[];
	static int result;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// �Է�
		arr = new int[t];
		dp = new int[t];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		//dp����
		result = 0;
		for (int i = 0; i < t; i++) { 
			_dp(i);
		}

		System.out.println(result);

	}

	private static void _dp(int end) {
		
		dp[end] = 1; //�ݵ�� 1  �־��� �κм����� 1 << 
		for (int i = 0; i < end; i++) {
			if(arr[i] < arr[end]) {
				dp[end] = Math.max(dp[i] + 1, dp[end]);
			}
		}
		result = Math.max(result,  dp[end]);
		
	}
}
