package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj10826_피보나치수4 {
	
	
	static BigInteger[] mamo ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		mamo = new BigInteger[t+1];
		
		
		System.out.println(_dp(t));
		
	}
	
	public static BigInteger _dp(int N ) {
		
		if(N == 0) {
			return BigInteger.ZERO;
			
		}
		
		mamo[0] = BigInteger.ZERO;
		mamo[1] = BigInteger.ONE;
		
		for (int i = 2; i <= N; i++) {
			mamo[i] = mamo[i-1].add(mamo[i-2]);
		}
		
		return mamo[N];
	}
	
}
