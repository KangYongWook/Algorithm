package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 
 * 문제 : 가지고있는 랜선으로 원하는 개수와 최대의길이 랜선 만들기
 * 작성자 : 강용욱
 * 설명
 */
public class bj_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] line = new int[N];
		int totlaLineLength= 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(br.readLine());
			totlaLineLength += line[i];
		}
		int result = 
		result = getResult(line, K, result);
		
		
		
		System.out.println(result);
		
	}
	public static int getResult(int[] line, int K, int result ) {
		
		int cnt = 0;
		int min = 0 ;
		int max = result;
		int mid = result/2;
		while(max-min >=0 ) {
			cnt = 0;
			for (int i = 0; i < line.length; i++) {
				cnt += line[i] / mid ;
			}
			if(cnt == K){
				return result;
			}
			else if(cnt < K ) {
				min = mid +1;
			}
			else {
				max = mid-1;
			}
			
			mid = (min + max) /2 ;
		}
		
		return -1;
	}
	
}
