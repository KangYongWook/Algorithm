package class2;

import java.util.Scanner;

public class bj_2292_���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 2 ; // �ι�° ������ ����
		int nextLine = 8 ; //������輱
		int calculate = 12; //��������
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
