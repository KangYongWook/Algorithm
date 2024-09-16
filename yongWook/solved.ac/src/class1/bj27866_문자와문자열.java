package class1;

import java.util.Scanner;

public class bj27866_문자와문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(str.charAt(sc.nextInt()-1));
	}
}
