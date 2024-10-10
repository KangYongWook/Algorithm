package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		1 2 3 4 5 6 7 8  9 10 11 12 13 14 15 16
		0 1 1  2 3 2 3  3 3 4 4     5  4
		
		int result = 0;
		
		int input = Integer.parseInt(br.readLine());
		int temp = input;
		while(true) {
			if(temp == 1) {
				break;
			}
			
			if( temp % 3 == 0 ) {
				temp /= 3 ;
				result++;
			}
			else {
				temp--;
				result++;
			}
			
		}
		
		temp = input;
		int result2 = 0;
		while(true) {
			if(temp == 1) {
				break;
			}
			
			if( temp % 2 == 0 ) {
				temp /= 2 ;
				result2++;
				
			}
			else {
				temp--;
				result2++;
			}
			
		}
		
		result = Math.min(result, result2);
		System.out.println(result);
	}
}
