package class2;

import java.util.*;
public class bj_1919_애너그램만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] countA = getAlphabetCount(sc.next());
		char[] countB = getAlphabetCount(sc.next());
		
		int result = 0;
		for (int i = 0; i < 26; i++) {
			result+= Math.abs(countA[i] - countB[i]);
		}
		System.out.println(result);
		
	}
	
	
	public static char[] getAlphabetCount(String str) {
		char count[] =new char[26];
 		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		return count;
	}
}
