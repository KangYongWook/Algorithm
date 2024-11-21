package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5525_IOIOI_50점 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//sb.append("IOI");
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
//		//OI기입
//		for (int i = 1; i < N; i++) {
//			sb.append("OI");
//		}
		
		int result = 0;
		String input = br.readLine();
		
		//입력받은거 판단
		for (int i = 0; i < M; i++) {
			
			//남은 탐색 길이보다 비교길이가 더크면 종료
			if( M-i < 3 + 2*(N-1)) {
				break; 
			}
			//바로 다음시작
			if(input.charAt(i) != 'I') {
				continue;
			}
			
			boolean isTrue = true; //일치여부 
			for (int j = 0; j < 3 + 2*(N-1) ; j++) {
				if( j % 2 == 0) { //짝수
					//같지않으면 바로 종료
					if(input.charAt(i+j) != 'I') {
						isTrue = false;
						i = i+j-1; //같지않은 위치
						break;
					}
				}else { //홀수
					//같지않으면 바로 종료
					if(input.charAt(i+j) != 'O') {
						isTrue = false;
						i = i+j-1; //같지않은 위치
						break;
					}
				}
			}
			if(isTrue) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
