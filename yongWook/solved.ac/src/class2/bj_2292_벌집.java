package class2;

import java.util.Scanner;

public class bj_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 2 ; // 두번째 경계부터 시작
		int nextLine = 8 ; //다음경계선
		int calculate = 12; //등차수열
		for (int i = 1; i <= N; i++) {
			
			if(N == 1 )
				result = 1;
			
			if( i == nextLine) {
				nextLine += calculate;
				calculate += 6;
				result++;
			}
		}
		
		System.out.println(result);
		
	//	1-6-12-18 - 24  
	//	1 7 19 37
	}
}
