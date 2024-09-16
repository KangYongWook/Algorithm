package class1;

import java.util.Scanner;

public class bj2884_알람시계 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if(M < 45) {
			M += 60;
			M -= 45;
			
			if(N == 0) {
				N = 24;
			}
			N -= 1;
			
		}else {
			M -= 45;
		}
		
		System.out.println(N+" "+M);
	}
}
