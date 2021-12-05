package class2;

import java.util.Scanner;

public class bj_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		double A = sc.nextInt();
		double B = sc.nextInt();
		double V = sc.nextInt();
		
		double temp = V-A;
		int result = 0;
		if(V-A > 0) {
			result = (int)Math.ceil(temp/(A-B));
			System.out.println(result+1);
		}else {
			System.out.println(1);
		}
		
		
	}
}
