package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int plusArr[] = new int[100000001];
		int minusArr[] = new int[100000001];
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 0;
		for (int i = 0; i < N; i++) {
			a = Integer.parseInt(st.nextToken());
			if( a >= 0) {
				plusArr[a]++;
			}else {
				minusArr[Math.abs(a)]++;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			a = Integer.parseInt(st.nextToken());
			if( a >= 0) {
				sb.append(plusArr[a]);
				sb.append(" ");
			}else {
				sb.append(minusArr[Math.abs(a)]);
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString().trim());
			
	}
		
		
		
		
		
}
