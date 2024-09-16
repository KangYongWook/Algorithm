package class2_1;

import java.util.Scanner;

public class bj4153_Á÷°¢»ï°¢Çü {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			boolean istrue = false; 
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a == 0 || b ==0 || c== 0) {
				return;
			}
			
		
			int max = Math.max(a, b);
			max = Math.max(max, c);
			
			if(a == max ) {
				if(a*a == b*b + c*c) istrue = true;
			}
			else if(b == max) {
				if(b*b == a*a + c*c) istrue = true;
				
			}else {
				if(c*c == b*b + a*a) istrue = true;
			}
			
			
			if(istrue) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
			
			
			
			
		}
			
		
	}
}
