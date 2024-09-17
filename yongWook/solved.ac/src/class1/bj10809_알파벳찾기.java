package class1;

import java.util.Scanner;

public class bj10809_¾ËÆÄºªÃ£±â {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int alphabet[] = new int[26];
		
		String str = sc.next();
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
		}
		
		
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			if( alphabet[idx] == -1 ) {
				alphabet[idx] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]);
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
