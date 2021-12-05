package class2;

import java.util.Scanner;

public class bj_2609_최대공약수와최소공배수_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		
		/** 완탐(브루트포스) **/
		//System.out.println(firstWay( firstNumber , secondNumber ));
		//System.out.println( firstNumber*secondNumber / firstWay( firstNumber , secondNumber ));
		
		/** 유클리드 호제법 **/
		System.out.println(secondWay( firstNumber , secondNumber ));
		System.out.println( firstNumber*secondNumber / secondWay( firstNumber , secondNumber ));
	}
	
	//브루트 포스
	public static int firstWay(int firstNumber , int secondNumber) {
		int result = 0;
		
		int min = firstNumber;
		if(firstNumber > secondNumber) 
			min = secondNumber;
	 
		for (int i = 1; i <= min; i++) {
			if( firstNumber%i ==0 && secondNumber%i == 0 ) {
				result = i;
			}
		}
		return result;
	}
	
	public static int secondWay(int firstNumber , int secondNumber) {
		int result = 0;
		
		int max = firstNumber;
		int min = secondNumber;
		if(firstNumber < secondNumber ) {
			max = secondNumber;
			min = firstNumber;
		}
			
		while(true) {
			result = max % min ;
			
			if(result == 0) {
				result = min;
				break;
			}
			max = min ;
			min = result;
		}
		
		return result;
	}
}
