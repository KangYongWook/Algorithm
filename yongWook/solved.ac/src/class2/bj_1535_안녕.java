package class2;

import java.util.Scanner;

public class bj_1535_¾È³ç {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int BaseEnergy = 100;
		int energy[] = new int[N];
		int point[] = new int[N];
		int result[] = new int[N];
		int temp = 0;
		for (int i = 0; i < N; i++) {
			energy[i] = sc.nextInt(); 
		}
		for (int i = 0; i < N; i++) {
			point[i] = sc.nextInt();
		}
		int index = 0;
		while(true) {
			
			for (int i = index; i < N; i++) {
				if(BaseEnergy - energy[i] > 0) {
					BaseEnergy -= energy[i];
					temp += point[i];
				}else {
					break;
				}
			}
			result[index] = temp;
			temp = 0;
			index ++;
			
			if(index == N) {
				break;
			}
		}
		
		int max = 0;
		for (int i = 0; i < result.length; i++) {
			if(result[i] > max ) {
				max = result[i];
			}
		}
		
		System.out.println(max);
		
		
	}
}
