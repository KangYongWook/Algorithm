package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_4949_±ÕÇüÀâÈù¼¼»ó {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		char[] chr = {};
		Stack<Character> stack;
		int stackSize = 0;
		while (true) {
			str = br.readLine();
			chr = str.toCharArray();
			stack = new Stack<Character>();
			int cnt = 0;
			int cnt1 = 0;
			stackSize = 0;
			
			if(str.equals(".")) {
				break;
			}
			for (int i = 0; i < chr.length; i++) {
				if (chr[i] == '(' || chr[i] == '[') {

					stack.add(chr[i]);
					cnt++;
				}
				if (chr[i] == ')') {
					if(stack.size() ==0) {
						stackSize = 1;
						break;
					}
					if (stack.peek() == '(') {
						stack.pop();
						cnt1++;
					}else {
						stackSize = 1;
						break;
					}
				}
				if (chr[i] == ']') {
					if(stack.size() ==0) {
						stackSize = 1;
						break;
					}
					if (stack.peek() == '[') {
						stack.pop();
						cnt1++;
					}else {
						stackSize = 1;
						break;
					}
				}

			}
			if(stackSize == 1) {
				System.out.println("no");
			}
			else if (cnt1 == cnt && stack.size() == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}
}
