package class4_1;

import java.util.Scanner;

public class BJ_1629_°ö¼À {
	
	static long C = 0 ;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong(); //¹Ø
		long B = sc.nextLong(); //Áö¼ö
		C = sc.nextLong();
		
		System.out.println(_pow(A, B));
		
	}
	
	public static long _pow(long A, long B) {
		
		if( B == 1) {
			return A % C;
		}
		long temp = _pow( A , B / 2);
		if(B % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}
}
