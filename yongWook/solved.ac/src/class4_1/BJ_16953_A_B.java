package class4_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_16953_A_B {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int result = -1;
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(A,1));
		//bfs
		while (!q.isEmpty()) {
			
			Point qOut = q.poll();
			if( qOut.x  == B) {
				result = qOut.depth;
				break;
			}
			
			if( qOut.x * 2 <= B) {
				q.add(new Point(qOut.x * 2, qOut.depth + 1));
			}
			
			//10억에서 오류남 1붙이면 100억 돼서 
			try {
				int temp = Integer.parseInt(String.valueOf(qOut.x) + "1");
				if( temp <= B) {
					q.add(new Point(temp, qOut.depth + 1));
				}
			} catch (Exception e) {
				continue;
			}
		}
			
		System.out.println(result);
	}
	
	static class Point {
		int x;
		int depth;
		
		Point(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
		
	}
}
