package class2_1;

import java.util.Scanner;

public class bj1546_ЦђБе {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int arr[] = new int[t];
		int maxNbr = 0;
		for (int i = 0; i < t; i++) {
			arr[i] = sc.nextInt();
			maxNbr = Math.max(arr[i], maxNbr);
		}
		
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += (double)arr[i] / maxNbr * 100; 
		}
		System.out.println( total / t);
	}
}
