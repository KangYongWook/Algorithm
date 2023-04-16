package class2;

import java.util.Scanner;

public class bj_1157_단어공부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next().toUpperCase();
		char alphabetCount[] = new char[26];
		int max = 0;
		int index = 0;
 		for (int i = 0; i < str.length(); i++) {
 			alphabetCount[str.charAt(i)-'A']++;
		}
 		
 		for (int i = 0; i < 26; i++) {
			max = Math.max(max, alphabetCount[i]);
		}
 		int cnt = 0;
 		for (int i = 0; i < 26; i++) {
			if(max == alphabetCount[i]){
				cnt++;
				index = i;
			}
		}
 		
 		if(cnt == 1)
 			System.out.println( (char)(index + 'A'));
 		else
 			System.out.println( "?");
	}
}
