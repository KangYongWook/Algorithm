package class1;

import java.util.Scanner;

public class bj2562_ÃÖ´ñ°ª {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int maxIndex = 0;
		int maxNumber = sc.nextInt();
		int input = 0;
		for (int i = 1; i < 9; i++) {
			input = sc.nextInt();
			if(maxNumber < input ) {
				maxIndex = i;
				maxNumber = input;
			}
		}
		
		System.out.println(maxNumber);
		System.out.println(maxIndex+1);
	}
}
