package class2;

import java.util.Scanner;

public class bj_2164_Ä«µå2_1 {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		//12345
		System.out.println(a.length());
		for (int i = a.length()-1; i >= 0; i--) {
			sb.append(a.charAt(i));
		}
		for (int i = b.length()-1; i >= 0; i--) {
			sb1.append(a.charAt(i));
		}
		
		
		if(  Integer.parseInt(sb.toString()) > Integer.parseInt(sb1.toString())  ){
			System.out.println(sb);
		}else {
			System.out.println(sb1);
		}
		
	}
}
