package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1003_피보나치함수 {
	static int number_0 = 0;
	static int number_1 = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			number_0 = 0;
			number_1 = 0;
			fibonacci(Integer.parseInt(br.readLine()));
			
			sb.append(number_0).append(" ").append(number_1);
			if( i != t-1)
				sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	
	public static void fibonacci(int n) {
		int temp1 = 0;
		int temp2 = 1;
		int temp = 0;
		if(n<0) {
			return ;
		}
		   if (n == 0) {
			   number_0++;
		        return ;
		    } else if (n == 1) {
		    	number_1++;
		        return ;
		    } else {
		    	for(int i = 1 ; i < n ; i++) {
					temp = temp1 + temp2;
					temp1 = temp2;
					temp2 = temp;
				}
		    	number_0 = temp1;
		    	number_1 = temp2;
		    }
		   
	}
}
