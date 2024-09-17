package class2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj7568_µ¢Ä¡ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int dungch[][] = new int[t][3];
		
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			dungch[i][0] = Integer.parseInt(st.nextToken());
			dungch[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < dungch.length; i++) {
			for (int k = 0; k < dungch.length; k++) {
				if( dungch[i][0] < dungch[k][0] && dungch[i][1] < dungch[k][1]) {
					dungch[i][2]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dungch.length; i++) {
			sb.append(dungch[i][2] +1 ).append(" ");
		}
		
		System.out.println(sb);
	}
}
