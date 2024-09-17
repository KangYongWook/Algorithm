package class1;

import java.util.Scanner;

public class bj10818_최소최대 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int max = -1000000;
		int min = 1000000;
		int input = 0;
		for (int i = 0; i < t; i++) {
			input = sc.nextInt();
			max = Math.max(max, input);
			min = Math.min(min, input);
		}
		
		System.out.println(min + " " + max);
		
	}
}
