package class2;

import java.util.Scanner;

public class bj_10250_ACMÈ£ÅÚ {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			if (H == 1) {
				System.out.println(100 + N);
			} else {
				if (N % H == 0)
					System.out.println(H*100+N/H);
				else
					System.out.println(100 * (N % H)+ (N / H) +1);
			}
		}

	}
}
