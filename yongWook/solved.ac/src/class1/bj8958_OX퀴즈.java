package class1;

import java.util.Scanner;

public class bj8958_OXÄûÁî {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		String str ;
		for (int i = 0; i < t; i++) {
			str = sc.next();
			
			int result = 0;
			int nbr = 0;
			for (int j = 0; j < str.length(); j++) {
				
				if(str.charAt(j) == 'O') {
					nbr++;
					result+= nbr;
				}else {
					nbr = 0;
				}
			}
			System.out.println(result);
		}
		
	}
}
