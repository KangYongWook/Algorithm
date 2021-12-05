package class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_10845_ť {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int number = 0;
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			
			switch (input) {
			case "push": {
				number = sc.nextInt();
				queue.offer(number);
				break;
			}
			case "front": {
				if (queue.isEmpty())
					sb.append("-1\n");
				else
					sb.append(queue.peek() + "\n");
				break;
			}
			case "size": {
				sb.append(queue.size() + "\n");
				break;
			}
			case "empty": {
				if (queue.isEmpty())
					sb.append("1" + "\n");
				else
					sb.append("0" + "\n");
				break;
			}
			case "pop": {
				if (queue.isEmpty())
					sb.append("-1" + "\n");
				else
					sb.append(queue.poll() + "\n");

				break;
			}
			case "back": {
				if (queue.isEmpty())
					sb.append("-1" + "\n");
				else
					sb.append(String.valueOf(number) + "\n");

				break;
			}
			default:
				break;
			}

		}
		System.out.println(sb);

	}
}
