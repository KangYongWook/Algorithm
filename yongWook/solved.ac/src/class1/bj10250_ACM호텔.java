package class1;

import java.util.Scanner;

public class bj10250_ACMÈ£ÅÚ {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int H, W, N ;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < t; i++) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			
			if(N % H == 0) {
				result.append( 100*(H) + N/H + "\n");
			}else {
				result.append(( N % H) * 100 + N/H + 1 + "\n");
			}
				
			
			
		}
		
		System.out.println(result.toString().trim());
	}
}
