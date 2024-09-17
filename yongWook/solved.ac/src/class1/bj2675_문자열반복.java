package class1;

import java.util.Scanner;

public class bj2675_문자열반복 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int r = 0;
		char[] str ;
		for (int i = 0; i < t; i++) {
			r = sc.nextInt();
			str = sc.next().toCharArray();
			
			for (int j = 0; j < str.length; j++) {
				
				for (int j2 = 0; j2 < r; j2++) {
					System.out.print(str[j]);
				}
				
			}
			System.out.println();
		}
	}
}
