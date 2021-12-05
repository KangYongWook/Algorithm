package class2;

import java.util.Scanner;
import java.util.Stack;

public class bj_10773_Á¦·Î {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		for (int i = 0; i < N; i++) {
			int number = sc.nextInt();
			if(number == 0) {
				stack.pop();
			}else {
				stack.push(number);
			}
		}
		
		int stackSize = stack.size();
		for (int i = 0; i < stackSize; i++) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}
