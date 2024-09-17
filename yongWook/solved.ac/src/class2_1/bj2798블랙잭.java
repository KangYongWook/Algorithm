package class2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2798∫Ì∑¢¿Ë {
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int t = Integer.parseInt(st.nextToken());
		int maxNbr = Integer.parseInt(st.nextToken());
		int nbrArr[] = new int[t];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			nbrArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int temp = 0;
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				
				if(j == i) {
					continue;
				}
				for (int k = j+1; k < t; k++) {
					
					if( k == j || k == i) {
						continue;
					}
					
					temp = nbrArr[i] + nbrArr[j] + nbrArr[k];
					if(temp <= maxNbr) {
						result = Math.max(result, temp);
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
