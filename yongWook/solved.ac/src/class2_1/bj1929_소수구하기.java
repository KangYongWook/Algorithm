package class2_1;

import java.util.Scanner;

public class bj1929_소수구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for (int i = M; i <= N; i++) {
			if(_isSingleNumber(i))
				System.out.println(i);
			
		}
		
				
	}
	
	public static boolean _isSingleNumber(int number) {
		
		if( number == 1) {
			return false;
		}
		else if( number == 2) {
			return true;
		}
		
		for (int i = 2; i <= Math.sqrt(number); i++) {
			
			if(number % i == 0 ) {
				return false;
			}
		}
		
		
		return true;
	}
}
