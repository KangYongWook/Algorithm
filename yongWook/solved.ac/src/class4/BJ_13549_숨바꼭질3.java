package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Point> q = new PriorityQueue<>((x, y) -> x.depth - y.depth);
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] memo = new boolean[2000000]; //메모리 초과로인한 메모이제이션 추가
		int[] depthMemo = new int[2000000]; //메모리 초과로인한 메모이제이션 추가 --> 어차피 정렬하기때문에 제거해도되긴함. 
		
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
			int depth = point.depth + 1  ;
			if( tempX >= 0 && (!memo[tempX] || (memo[tempX] && depthMemo[tempX] > depth ))) { //방문을 안했거나, 방문했어도 depth가 내가 더 작으면 q에 넣음.
				memo[tempX] = true;
				depthMemo[tempX] = depth;
				q.add(new Point(tempX, depth));
			}
			
			
			//조건2
			tempX = point.x + 1;
			if( tempX <= 200000 && (!memo[tempX] || (memo[tempX] && depthMemo[tempX] > depth ))) {
				memo[tempX] = true;
				depthMemo[tempX] = depth;
				q.add(new Point(tempX, depth));
			}
			
			//조건3 순간이동
			tempX = point.x * 2;
			depth = point.depth;
			if( tempX <= 200000 && (!memo[tempX] || (memo[tempX] && depthMemo[tempX] > depth )))  {
				memo[tempX] = true;
				depthMemo[tempX] = depth;
				q.add(new Point( tempX, depth));
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
