package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074_Z {
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); //행
		int c = Integer.parseInt(st.nextToken()); //열
		int size = (int) Math.pow(2, N); //한 변의 사이즈
		
		_startZ(size, r, c);
		System.out.println(cnt);
	}

	private static void _startZ(int size, int r, int c) {
		
		if(size == 1)
			return;
		
		//첫번째 네모 ( 1사분면 )
		if(r < size/2 && c < size/2) {
			_startZ(size/2, r, c);
		}
		//두번째 네모 ( 2사분면 )
		else if(r < size/2 && c >= size/2) {
			cnt += size * size / 4; 
			_startZ(size/2, r, c - size/2);
		}
		//세번쨰 네모 ( 3사분면 ) 
		else if(r >= size/2 && c < size/2) {
			cnt += (size * size / 4) * 2;
			_startZ(size/2, r - size/2, c);
		}
		else {
			cnt += (size * size / 4) * 3;
			_startZ(size/2, r - size/2, c - size/2);
		}
	}
}
