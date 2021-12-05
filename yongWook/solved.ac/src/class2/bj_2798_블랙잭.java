package class2;

import java.util.Iterator;
import java.util.Scanner;

public class bj_2798_∫Ì∑¢¿Ë {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int number = sc.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		OUTER:
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				for (int k = j+1; k < arr.length; k++) {
					
					if(arr[i]+ arr[j]+ arr[k] > number) {
						continue;
					}
					if(max < arr[i]+ arr[j]+ arr[k]) {
						max = arr[i]+ arr[j]+ arr[k];
						if(max == number) {
							break OUTER;
						}
					}
					
				}
			}
		}
		
		System.out.println(max);
	}
}
