package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[M+1];
		st = new StringTokenizer(br.readLine());
		
		//입력 
		int temp = 0;
		for (int i = 1; i <= M; i++) {
			temp += Integer.parseInt(st.nextToken());
			arr[i] = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		//구간합
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int result = 0;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(start != 1) {
				result = arr[end] - arr[start-1];
			}else {
				result = arr[end];
			}
			
			sb.append(result).append('\n');
		}
		
		System.out.println(sb);
	}
}

