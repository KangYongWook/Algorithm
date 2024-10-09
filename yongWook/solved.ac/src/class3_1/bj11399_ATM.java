package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11399_ATM {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Á¤·ÄÈÄ dp?
		
		int t = Integer.parseInt(br.readLine());
		int time[] = new int[t];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < time.length; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int temp = 0;
		int result = 0;
		for (int i = 0; i < time.length; i++) {
			temp += time[i];
			result += temp; 
		}
		
		System.out.println(result);
		
		
	}
}
