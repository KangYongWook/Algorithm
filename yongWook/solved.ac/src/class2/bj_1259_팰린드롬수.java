package class2;

import java.util.Iterator;
import java.util.Scanner;

public class bj_1259_ÆÓ¸°µå·Ò¼ö {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		String input = "" ;
		char arr[] ;
		while(true) {
			input = sc.next();
			if(input.equals("0")) {
				break;
			}
			arr = new char[input.length()];
			
			arr = input.toCharArray();
			
			for (int i = arr.length-1; i >= 0; i--) {
				sb.append(arr[i]);
			}
			
			if(input.equals(sb.toString())) {
				result.append("yes\n");
			}else {
				result.append("no\n");
			}
			
			sb.setLength(0);
			
		}
		System.out.println(result.toString());
	}
}
