package class2_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class bj11866_요세푸스문제O {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(true) {
			
			for (int i = 0; i < M-1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
			
			if(q.isEmpty()) {
				break;
			}
			
		}
		
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
				
	}
}
