package class1;

import java.util.Scanner;

public class bj2577_숫자의개수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int result[] = new int[10];
		
		
		int t = sc.nextInt()* sc.nextInt()* sc.nextInt();
		while (true) {
			result[t % 10]++;
			t = t/10;
			
			if(t == 0) {
				break;
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		
	}
}
