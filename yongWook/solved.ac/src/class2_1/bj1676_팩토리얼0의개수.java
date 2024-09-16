package class2_1;

import java.math.BigInteger;
import java.util.Scanner;

public class bj1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		BigInteger number =  _factorial(N);
		String str = String.valueOf(number);
		for (int i = str.length()-1; i >0 ; i--) {
			if(str.charAt(i) == '0') {
				result++;
			}
			else {
				break;
			}
		}
		
		
		
		System.out.println(result);
		
	}
	
	public static BigInteger _factorial(int number) {
		
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= number; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}
}
