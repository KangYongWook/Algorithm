package class2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class bj_10866_µ¦ {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Deque<Integer> deq = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int front = 0;
		int back = 0;
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			
			switch (input) {
			case "push_front": {
				front = sc.nextInt();
				deq.addFirst(front);
				break;
			}
			case "push_back": {
				back = sc.nextInt();
				deq.addLast(back);
				break;
			}
			case "pop_front": {
				if (deq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deq.pollFirst() + "\n");
				break;
			}
			case "pop_back": {
				if (deq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deq.pollLast() + "\n");
				break;
			}
			case "size": {
				sb.append(deq.size() + "\n");
				break;
			}
			case "empty": {
				if (deq.isEmpty())
					sb.append("1" + "\n");
				else
					sb.append("0" + "\n");
				break;
			}
			case "front": {
				if (deq.isEmpty())
					sb.append("-1" + "\n");
				else
					sb.append(deq.peekFirst() + "\n");

				break;
			}
			case "back": {
				if (deq.isEmpty())
					sb.append("-1" + "\n");
				else
					sb.append(deq.peekLast() + "\n");

				break;
			}
			default:
				break;
			}

		}
		System.out.println(sb);

	}
}
