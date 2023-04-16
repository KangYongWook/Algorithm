package class3;

import java.util.Scanner;

public class bj_1003_피보나치함수2 {
	private static int result1 = 0;
	private static int result2 = 0;
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		
		for (int i = 0; i < repeat; i++) {
			fibonacci(sc.nextInt());
			System.out.println(result1 + " " + result2);
		}
	}
	
	private static void fibonacci(int n) {
		result1 = 0;
		result2 = 0;
				
		int temp0 = 0;
		int temp1 = 0;
		int temp2 = 1;
	    if (n == 0) {
	        result1++;
	    } else if (n == 1) {
	        result2++;
	    } else {
	    	for (int i = 0; i < n-1; i++) {
				
	    		temp0 = temp1 + temp2;
	    		temp1 = temp2;
	    		temp2 = temp0;
	    		
	    		result1= temp1;
	    		result2 = temp2;
			}
	    }
	}
	
	
	
}
