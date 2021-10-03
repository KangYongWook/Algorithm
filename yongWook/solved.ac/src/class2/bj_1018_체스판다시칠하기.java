package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;


public class bj_1018_체스판다시칠하기 {
	static char startblack[] ;
	static char startwhite[] ;
	static char map[][] ;
	public static void main(String[] args) throws Exception{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		startblack = new char[8];
		startwhite = new char[8];
		for (int i = 0; i < startwhite.length; i++) {
			if(i%2 ==0) {
				startblack[i]= 'B';
				startwhite[i]= 'W';
			}else {
				startblack[i]= 'W';
				startwhite[i]= 'B';
			}
		}

		map = new char[N][M];
		String input ;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		int result = Integer.MAX_VALUE;
		int temp = 0;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				temp = check(i,j);
				if(result >temp ) {
					result = temp;
				}
			}
		}
		System.out.println(result);

	}

	public static int check(int x , int y ) {
		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = x; i < 8+x; i++) {
			for (int j = y; j < 8+y; j++) {

				if(i%2 == 0  ) { //짝수냐
					if( map[i][j] == startblack[j-y]){  // 블랙시작
						cnt2++;
					}else {  // 화이트시작
						cnt1++;
					}

				}else { //홀수냐
					if( map[i][j] == startwhite[j-y]){  // 블랙시작
						cnt2++;
					}else {  // 화이트시작
						cnt1++;
					}
				}
				
			}
		}
		if(cnt1>cnt2) {
			return cnt2;
		}else {
			return cnt1;
		}


	}


}
