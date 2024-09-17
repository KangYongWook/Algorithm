package class1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1152_단어의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		

		System.out.print(st.countTokens());
		
	}
}
