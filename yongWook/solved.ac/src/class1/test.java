package class1;

import java.util.Scanner;

public class test {	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();
		
		
		
		for (int i = 0; i < t; i++) {
			if(t== 0) break;
			String in = sc.next();
			char inArr[] = in.toCharArray();
			int max = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < in.length(); j++) {
				if(max < inArr[j])
					max = inArr[j]-'0';
				if(min > inArr[j])
					min = inArr[j]-'0';
			} 
			
			for (int j = 0; j < inArr.length; j++) {
				
			}
			System.out.println((int)max);
			for (int j = 0; j < inArr.length; j++) {
				System.out.print(inArr[j]);
			}
			
		}
		if(t==0) System.out.println("#1" + " " + "0" + " " + "0");
		
		
	}
}
