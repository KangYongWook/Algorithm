package class2;

import java.util.Scanner;

public class bj_4153_Á÷°¢»ï°¢Çü {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if( a == 0|| b==0||c == 0) {
				break;
			}
			int arr[] = { a, b, c };
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				if (max < arr[i])
					max = arr[i];
			}

			if (a == max) {
				if (b * b + c * c == a * a) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}
			if (b == max) {
				if (a * a + c * c == b * b) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}
			if (c == max) {
				if (b * b + a * a == c * c) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}
		}

	}
}
