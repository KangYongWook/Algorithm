package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2747_피보나치수 {
	
	static int[] mamo ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		mamo = new int[t];
		System.out.println(_fibo(t));
		
	}
	
	public static int _fibo(int N ) {
		
		if( N == 0) {
			return 0;
		}
		else if(N == 1) {
			return 1;
		}
		else {
			
			if(mamo[N-1] == 0) {
				mamo[N-1] = _fibo(N-2) + _fibo(N-1);
				return mamo[N-1];
			}
			else {
				return mamo[N-1];
			}
		}
	}
}
