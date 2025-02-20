package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
	private static Queue<Point> q ;
	private static int N ;
	private static int map[][] ;
	private static int resultMap[][] ;
	private static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		q = new LinkedList<Point>();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		resultMap = new int[N][N];
		//입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		if(map[N-1][N-1] ==1) {
			System.out.println(0);
		}else {
			//bfs
			_bfs();
			System.out.println(resultMap[N-1][N-1]);
		}
		
		//System.out.println(result);
		
		
		
	}
	
	public static void _bfs() {
		q.add(new Point(1,0,1));
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			int currentX = point.x;
			int currentY = point.y;
			int shape = point.shape;
//			
//			//도착한 결과 증가
//			if(currentX == N-1 && currentY == N-1 ) {
//				result++;
//				continue;
//			}
			resultMap[currentX][currentY]++;
			
			if(shape == 1) {
				//가로
				if( _isRow(currentX, currentY) ) {
					q.add(new Point(currentX+1, currentY, 1));
				}
				
				//대각
				if( _isRowCol(currentX, currentY)) {
					q.add(new Point(currentX+1, currentY+1, 3));
				}
			}
			else if(shape == 2) {
				//세로
				if( _isCol(currentX, currentY) ) {
					q.add(new Point(currentX, currentY+1, 2));
				}
				
				//대각
				if( _isRowCol(currentX, currentY) ) {
					q.add(new Point(currentX+1, currentY+1, 3));
				}
			}
			else {//대각
				
				//가로
				if( _isRow(currentX, currentY)) {
					q.add(new Point(currentX+1, currentY, 1));
				}
				
				//세로
				if( _isCol(currentX, currentY) ) {
					q.add(new Point(currentX, currentY+1, 2));
				}
				
				//대각
				if( _isRowCol(currentX, currentY) ) {
					q.add(new Point(currentX+1, currentY+1, 3));
				}
			}
		}//while end
	}
	
	public static boolean _isRow(int x, int y) {
		
		//가로
		if( x+1 < N && map[y][x+1] != 1 ) {
			return true;
		}
		return false;
	}
	
	public static boolean _isCol(int x, int y) {
		
		//세로
		if( y+1 < N && map[y+1][x] != 1) {
			return true;
		}
		return false;
	}
	
	public static boolean _isRowCol(int x, int y) {
		
		//대각
		if(  x+1 < N && y+1 < N && map[y+1][x+1] != 1 && map[y+1][x] != 1 && map[y][x+1] != 1 ) {
			return true;
		}
		return false;
	}

	public static class Point{
		int x;
		int y;
		int shape; //가로 : 1 세로 : 2 대각 : 3
		Point(int x, int y, int shape){
			this.x = x;
			this.y = y;
			this.shape = shape; 
		}
		
	}
}
