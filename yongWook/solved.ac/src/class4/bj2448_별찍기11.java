package class4;

import java.util.Scanner;

public class bj2448_º°Âï±â11 {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(" ");
		}
		sb.append("*").append("\n");
		
		for (int i = 0; i < N-1; i++) {
			sb.append(" ");
		}
		sb.append("* *").append("\n");
		
		for (int i = 0; i < N-2; i++) {
			sb.append(" ");
		}
		sb.append("*****");
		
		System.out.print(sb);
		
	}
}
