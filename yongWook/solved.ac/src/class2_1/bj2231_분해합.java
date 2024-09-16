package class2_1;

import java.util.Scanner;

public class bj2231_ºÐÇØÇÕ {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		int temp = 0;
		for (int i = 1; i < N; i++) {
			
			result = i;
			temp = i;
			while(true) {
				if(temp<=0) break;
				result +=  temp % 10;
				temp = temp / 10;
			}
			if(result == N) {
				result = i;
				break;
			}else {
				result = 0;
			}
		}
		
		System.out.println(result);
	}
}
