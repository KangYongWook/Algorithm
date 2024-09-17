package class2_1;

import java.util.Scanner;

public class bj11050_이항계수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(_factorial(a)/(_factorial(a-(a-b))*_factorial(a-b)));
	}
	
	
	public static int _factorial(int number) {
		
		int result = 1;
		
		for (int i = 1; i <= number; i++) {
			result*= i;
		}
		
		return result; 
		
	}
}
