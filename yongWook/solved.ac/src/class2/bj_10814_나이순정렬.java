package class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj_10814_나이순정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String arr[][] = new String[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.next();
			}
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
				
			}
			
		} 
		);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				if(j== 0)
					System.out.print(arr[i][j] + " ");
				else
					System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}	
