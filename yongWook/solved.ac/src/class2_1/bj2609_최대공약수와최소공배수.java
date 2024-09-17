package class2_1;

import java.util.Scanner;

public class bj2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int nbr1 = sc.nextInt();
		int nbr2 = sc.nextInt();
		
		int result1 = 0;
		int result2 = 0;
		
		int max = Math.max(nbr1, nbr2);
			
		if( max == nbr1 ) {
			result1 = gcd(max, nbr2);
		}else {
			result1 =  gcd(max, nbr1);
		}
		
		result2 =nbr1*nbr2 /result1;
			
		
		
		System.out.println(result1);
		System.out.println(result2);
				
	}
	
	public static int gcd( int a , int b ) {
		
		if(b == 0) {
			return a;
		}
		
		return gcd( b , a% b);
	}
}
