package class1;

import java.util.Scanner;

public class bj2920_À½°è {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int firstNbr = sc.nextInt();
		
		if(firstNbr == 1) {
			_ascending(sc);
		}
		else if(firstNbr == 8) {
			_descending(sc);
		}
		else {
			System.out.println("mixed");
		}
		
	}
	
	public static void _ascending(Scanner sc) {
		for (int i = 2; i <= 8; i++) {
			if(sc.nextInt() != i) {
				System.out.println("mixed");
				return;
			}
		}
		System.out.println("ascending");
		
	}
	
	public static void _descending(Scanner sc) {
		for (int i = 7; i >= 1; i--) {
			if(sc.nextInt() != i) {
				System.out.println("mixed");
				return;
			}
		}
		System.out.println("descending");
	}
}
