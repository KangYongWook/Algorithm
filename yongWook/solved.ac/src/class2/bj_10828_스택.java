package class2;

import java.util.Scanner;
import java.util.Stack;

public class bj_10828_Ω∫≈√ {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String input = sc.next();

			switch (input) {
			case "push": {
				int number = sc.nextInt();
				stack.push(number);
				break;
			}
			case "top": {
				if (stack.isEmpty())
					sb.append("-1\n");
				else
					sb.append(stack.peek() + "\n");
				break;
			}
			case "size": {
				sb.append(stack.size() + "\n");
				break;
			}
			case "empty": {
				if (stack.isEmpty())
					sb.append("1" + "\n");
				else
					sb.append("0" + "\n");
				break;
			}
			case "pop": {
				if (stack.isEmpty())
					sb.append("-1" + "\n");
				else
					sb.append(stack.pop() + "\n");

				break;
			}
			default:
				break;
			}

		}
		System.out.println(sb);

	}
}
