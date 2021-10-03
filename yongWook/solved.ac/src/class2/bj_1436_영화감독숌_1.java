package class2;

import java.util.Scanner;

/**
 * 
 * 문제 : 단어정렬  단어가 짧은거부터 정렬
 * 작성자 : 강용욱
 * 설명 : 
 */
public class bj_1436_영화감독숌_1 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int cnt = 0 ;
		for (int i = 666; i < Integer.MAX_VALUE; i++) {
			if(Integer.toString(i).contains("666")) {	
				
				arr[cnt] = i;
				cnt++;
				if(cnt == N)
					break;
			}
		}
		System.out.println(arr[N-1]);
		
	}
}
