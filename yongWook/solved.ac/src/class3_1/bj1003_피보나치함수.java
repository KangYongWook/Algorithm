package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1003_피보나치함수 {
	
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int input = Integer.parseInt(br.readLine()); 
			
			if(input == 0) {
				System.out.println("1 0");
			}
			else if(input == 1) {
				System.out.println("0 1");
			}
			else {
				arr = new int[input+1];
				_dp(input);
				System.out.println(arr[input-1] + " " + arr[input] );
			}
		}
		
	}
	
	public static void _dp(int number){
	
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= number; i++) {
			arr[i] =  arr[i-1] + arr[i-2];
		}
	}
}
