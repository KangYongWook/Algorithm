package class2_1;

import java.util.Scanner;

public class bj1978_소수찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0 ;
		for (int i = 0; i < N; i++) {
			
			if(is_prime(sc.nextInt())) result++;
		}
		System.out.println(result);
		
	}
	
	public static boolean is_prime(int number) {
		
		if(number == 1) {
			return false;
		}
		if(number == 2) {
			return true;
		}
		
		for (int j = 2; j <= Math.sqrt(number); j++) {
			
			if( number % j == 0) {
				return false;
			}
		}
		
		return true;
	}
}
