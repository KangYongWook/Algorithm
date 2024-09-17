package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1018_체스판다시칠하기 {
	static char map[][] ;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < h-7; i++) {
			for (int j = 0; j < w-7; j++) {
				result = Math.min(result,_isValidation(i,j));
			}
		}
		System.out.println(result);
		
	}
	
	public static int _isValidation(int y, int x) {
		
		char white[] = {'W','B','W','B','W','B','W','B'};
		char black[] = {'B','W','B','W','B','W','B','W'};
		
		//white start
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < black.length; j++) {
				if(i % 2 > 0 ) {
					if(map[y+i][x+j] != white[j]) {
						cnt++;
					}
				}
				else {
					if(map[y+i][x+j] != black[j]) {
						cnt++;
					}
				}
			}
		}
		//black start
		int cnt2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < black.length; j++) {
				if(i % 2 > 0 ) {
					if(map[y+i][x+j] != black[j]) {
						cnt2++;
					}
				}
				else {
					if(map[y+i][x+j] != white[j]) {
						cnt2++;
					}
				}
			}
		}
		return Math.min(cnt, cnt2);
	}
}
