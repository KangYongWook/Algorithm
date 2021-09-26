package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1436_¿µÈ­°¨µ¶¼ò {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int number = 666;
		int cnt = 1;
		
		while(N != cnt) {
			number++;
			
			if(String.valueOf(number).contains("666")) {
				cnt++;
			}
		}
		System.out.println(number);
	}
}
