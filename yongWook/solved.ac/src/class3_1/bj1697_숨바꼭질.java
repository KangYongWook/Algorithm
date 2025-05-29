package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697_숨바꼭질 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> q = new LinkedList<Point>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] memo = new boolean[2000000]; //메모리 초과로인한 메모이제이션 추가
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//동생이 작은 위치에 있으면 바로 끝내기
		if(n  >= k ) {
			System.out.println(n-k);
			return;
		}
		
		int result = 0;
		//입력
		q.add(new Point( n, 0));
		while(!q.isEmpty()) {
			
			Point point = q.poll();
			if( point.x == k ) {
				result = point.depth;
				break;
			}
			
			//조건1
			int tempX = point.x -1;
			if( tempX >=0 && !memo[tempX]) { //도착지점보다 초과한값이 -1할때말고는 필요없어 해당 조건 부여.
				memo[tempX] = true;
				q.add(new Point(tempX, point.depth+1));
			}
			
			
			//조건2
			tempX = point.x + 1;
			if( tempX <= 200000 && !memo[tempX]) {
				memo[tempX] = true;
				q.add(new Point(tempX, point.depth+1));
			}
			
			//조건3 순간이동
			tempX = point.x * 2;
			if( tempX <= 200000 && !memo[tempX] ) {
				memo[tempX] = true;
				q.add(new Point( tempX, point.depth+1));
			}
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
