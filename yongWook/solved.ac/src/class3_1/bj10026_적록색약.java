package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj10026_적록색약 {
	
	static Queue<Point> q;
	static boolean visited[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0, 0,1,-1};
	static int row, col;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		row = t;
		col = t;
		
		char map[][] = new char[col][row];
		char colorWeaknessMap[][] = new char[col][row];
		
		visited = new boolean[col][row];
		q = new LinkedList<Point>();
		for (int i = 0; i < col; i++) {
			String input = br.readLine();
			for (int j = 0; j < row; j++) {
				char temp = input.charAt(j);
				map[i][j] = temp;
				
				temp = temp == 'R' ? 'G' : temp;
				colorWeaknessMap[i][j] = temp;
			}
		}
		
		//정상시야
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(!visited[i][j]) {
					_bfs(j,i, map);
				}
			}
		}
		System.out.print(result + " ");
		
		//색약시야
		visited = new boolean[col][row];
		result = 0 ;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(!visited[i][j]) {
					_bfs(j,i, colorWeaknessMap);
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void _bfs(int x, int y, char[][] map) {
		
		q.add(new Point(x, y, map[y][x]));
		visited[y][x] = true;
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				int color = point.color;
				if( nx >= 0 && ny >= 0 && nx < row && ny < col && color == map[ny][nx] && !visited[ny][nx]) {
					q.add(new Point(nx, ny, map[ny][nx]));
					visited[ny][nx] = true;
				}
				
			}
		}
		result++;
	}
	
	static class Point{
		int x;
		int y;
		int color;
		Point(int x, int y, int color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
}
