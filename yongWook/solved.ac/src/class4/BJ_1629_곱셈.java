package class4;

import java.util.Scanner;

public class BJ_1629_°ö¼À {
	static long c ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		c = sc.nextLong();
		
		System.out.println(_pow(a,b));
	}
	
	public static long _pow(long a, long b) {
		
		if(b == 1) {
			return a % c;
		}
		
		long x = _pow(a, b/2);
		if( b % 2 == 0) {
			return x * x % c;
		}
		else {
			return (x * x % c )* a % c;
		}
	}
}
