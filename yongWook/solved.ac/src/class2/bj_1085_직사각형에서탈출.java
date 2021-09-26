package class2;

import java.util.Scanner;

public class bj_1085_직사각형에서탈출 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y=  sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int minX = 0;
		int minY = 0;
		if(x > w/2 ) {
			minX = w-x;
		}
		else {
			minX = x;
		}

		if(y > h/2) {
			minY = h-y;
		}else {
			minY = y;
		}
		int result = 0;
		result = (minX > minY) ? minY : minX;
		System.out.println(result);

	}
}
