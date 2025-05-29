package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> q = new LinkedList<Point>();
		int result = 0;
		
		//입력
		q.add(new Point(Integer.parseInt(br.readLine()), 0));
		while(!q.isEmpty()) {
			
			Point depth = q.poll();
			if( depth.x == 1) {
				result = depth.depth;
				break;
			}
			
			if(depth.x % 3 == 0) {
				q.add(new Point(depth.x/3, depth.depth+1));
			}
			if(depth.x % 2 == 0) {
				
				q.add(new Point(depth.x/2, depth.depth+1));
			}
			q.add(new Point(depth.x-1, depth.depth+1));
			
		}
		
		System.out.println(result);
		
		
	}
	
	static class Point{
		
		int x;
		int depth;
		
		Point(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
		
		
	}
}
