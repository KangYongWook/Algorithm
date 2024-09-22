package class2_1;

import java.util.Scanner;

public class bj2775_부녀회장이될테야 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int floor = 0;
		int ho = 0;
		for (int i = 0; i < N; i++) {
			floor = sc.nextInt();
			ho = sc.nextInt();
			int result = 0;
			for (int j =  0; j < ho; j++) {
				result += floor++;
				
			}
			System.out.println(result);
		}
		
		
		
		
		
		
	}
}
