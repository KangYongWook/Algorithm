package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1541_ÀÒ¾î¹ö¸°°ýÈ£ {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String input = br.readLine();
		
		long result = 0;
		if(input.contains("-")) {
			String minusArr[] = input.split("-");
			
			for (int i = 0; i < minusArr.length; i++) {
				
				long temp = 0;
				if(minusArr[i].contains("+")) {
					String plusArr[] = minusArr[i].split("\\+");
					for (int j = 0; j < plusArr.length; j++) {
						temp += Integer.parseInt(plusArr[j]);
					}
					if(i ==0) {
						result = temp;
					}else {
						result -= temp;
					}
				}
				else {
					
					if(i ==0) {
						result = Integer.parseInt(minusArr[i]);
					}else {
						result -= Integer.parseInt(minusArr[i]);
					}
					
				}
			}
		}
		else {
			String arr[] = input.split("\\+");
			for (int i = 0; i < arr.length; i++) {
				result += Integer.parseInt(arr[i]);
			}
		}
		
		System.out.println(result);
		
	}
}
