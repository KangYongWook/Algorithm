package class2;

import java.util.Scanner;

public class bj_2231_ºÐÇØÇÕ {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int length = String.valueOf(N).length();
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(decompositionSum(i, length) == N ) {
				result = i;
				break;
			}
		}
			
		System.out.println(result);	
		
	}
	
	
	public static int decompositionSum(int number, int length) {
		int result = number;
		
		for (int i = 0; i < length; i++) {
			result += number%10;
			number = number/10;
		}
		return result;
	}
	
	
}
