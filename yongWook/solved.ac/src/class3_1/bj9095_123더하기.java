package class3_1;

import java.util.Scanner;

public class bj9095_123¥ı«œ±‚ {
	
	static int arr[] = new int[11];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			
			int input = sc.nextInt();
			_dp(input);
			System.out.println(arr[input-1]);
		}
		
	}
	
	public static void _dp(int number) {
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		
		for (int i = 3; i <= number; i++) {
			arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
		}
	}
}
