package class2;
import java.util.*;

public class bj_2744_대소문자바꾸기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			char charStr = str.charAt(i); 
			if('A'<=charStr && charStr < 'Z') {
				System.out.print((char)('a' + charStr - 'A'));
			}
			else {
				System.out.print((char)('A' + charStr - 'a'));
			}
				
		}
		
	}
}
