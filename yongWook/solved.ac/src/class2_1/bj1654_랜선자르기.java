package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1654_랜선자르기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int loapCnt = Integer.parseInt(st.nextToken());
		int[] arr = new int[t];
		
		int max = Integer.MAX_VALUE;
		int total = 0;
		int result = 0;
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
			max = Math.min(max, arr[i]);
		}
		
		if(max > Math.ceil(total/ t)) {
			max = (int) Math.ceil(total/ t);
		}
		
		int temp = 0;
		while(true){
			temp = 0;
			
			for (int i = 0; i < arr.length; i++) {
				temp += arr[i] / max;
			}
			
			if(temp == loapCnt) {
				result = max;
				break;
			}
			max--;
		}
			
		
		
		
		
		System.out.println(result);
		
		
	}
}
