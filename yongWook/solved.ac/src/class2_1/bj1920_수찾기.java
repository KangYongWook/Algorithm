package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1920_¼öÃ£±â {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] pluseSearchMap = new int[100001];
		int[] minusSearchMap = new int[100001];
		
		int nbr ;
		for (int i = 0; i < N; i++) {
			nbr = Integer.parseInt(st.nextToken()); 
			if( nbr < 0 ) {
				minusSearchMap[Math.abs(nbr)]++;
			}else {
				pluseSearchMap[nbr]++;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			nbr = Integer.parseInt(st.nextToken()); 
			if( nbr < 0 ) {
				if(minusSearchMap[Math.abs(nbr)] > 0) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}else {
				if(pluseSearchMap[nbr] > 0) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
		
		
	}
}
