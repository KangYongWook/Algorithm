package class2_1;

import java.util.Scanner;

public class bj2292_¹úÁý {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result = 1;
		int temp = 6;
		while(N >= 2) {
			result++;
			
			N = N -temp;
			temp += 6;
			
			
		}
		
		System.out.println(result);
	}
}
