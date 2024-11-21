package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5525_IOIOI_100점 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int result = 0;
		String input = br.readLine();
		
		int cnt = 0;
		boolean isTrueI = false;
		//입력받은거 판단
		for (int i = 0; i < M; i++) {
			
			if(!isTrueI && input.charAt(i) == 'I') {
				isTrueI = true; 
				cnt++;
			}
			else if(isTrueI && input.charAt(i) == 'O') {
				isTrueI = false;
				cnt++;
			}
			else {
				isTrueI = false;
				cnt = 0;
				
				if(!isTrueI && input.charAt(i) == 'I') {
					isTrueI = true; 
					cnt++;
				}
				else if(isTrueI && input.charAt(i) == 'O') {
					isTrueI = false;
					cnt++;
				}
			}
			
			if(cnt >= 3 + 2*(N-1) && input.charAt(i) == 'I') {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
