package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int cnt = 0;
		int result = 0; 
		
		for (int i =  666; i < Integer.MAX_VALUE; i++) {
			/*
			if(String.valueOf(i).contains("666")) {
				cnt++;
				result = i;
				if(cnt == t) {
					break;
				}
			}*/
			
			if( _isTrue (i)) {
				cnt++;
				result = i;
				if(cnt == t) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}
		
	public static boolean _isTrue(int number) {
		
		while(true) {
			if( number % 1000 == 666) {
				return true;
			} 
			
			number = number /10;
			if(number == 0 ) {
				return false;
			}
		}
	}
		
		
		
}
