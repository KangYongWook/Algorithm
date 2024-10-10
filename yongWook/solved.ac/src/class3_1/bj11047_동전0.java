package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11047_µ¿Àü0 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int amt = Integer.parseInt(st.nextToken());
		
		int dongen[] = new int[t];
		for (int i = 0; i < t; i++) {
			dongen[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		for (int i = dongen.length -1 ; i >= 0 ; i--) {
			
			if( dongen[i] <= amt) {
				result += amt / dongen[i] ; 
				amt = amt % dongen[i];
			}
			
			if( amt == 0) {
				break;
			}
		}
		
		System.out.println(result);
	}
}
