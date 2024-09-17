package class2_1;

import java.util.Scanner;

public class bj1259_ÆÓ¸°µå·Ò¼ö {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String t ;
		char arr[] ; 
		while(true) {
			
			t = sc.next();
			if( t.equals("0")) {
				break;
			}
			
			arr = t.toCharArray();
			boolean istrue = true;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] != arr[arr.length -1 - i]) {
					istrue = false;
				}
			}
			
			if(istrue) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}
	}
}
