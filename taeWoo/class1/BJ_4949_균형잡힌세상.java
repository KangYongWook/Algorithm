package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class BJ_4949_±ÕÇüÀâÈù¼¼»ó {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(true) {
			sb.append(input(br.readLine())).append('\n');
			
		}
	}
	
	public static String input(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.push(c);
			}
			else if(c == '[') {
				stack.push(c);
			}
			else if(stack.empty()) {
				return "no";
			}
			else if(!(c == '(' && c==')' && c =='[' && c== ']')) {
				return "yes";
			}
			else {
				stack.pop();
			}
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
		
	}

}
