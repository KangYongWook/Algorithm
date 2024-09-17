package class2_1;

import java.util.Scanner;


public class bj2869_달팽이는올라가고싶다 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		int temp = (v-a)/(a-b);
		int result = 0;
		
		if( v-a == 0) {
			result = 1;
		}
		else {
			if( (v-a) % (a-b) > 0) {
				result = temp + 2;
			}
			else {
				result = temp + 1;
			}
			   
		}
		
		
		
		System.out.println(result);
				
		
	}
}
