package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576_≈‰∏∂≈‰ {
	
	static int map[][];
	static boolean visited[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0, 0,1,-1};
	static int row, col;
	static int result = 0;
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[col][row];
		visited = new boolean[col][row];
		q = new LinkedList<Point>();
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					 q.add(new Point(j, i, 0));
					 visited[i][j] = true;
				}
			}
		}
		
		_bfs();
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(map[i][j] == 0) {
					result = -1;
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	private static void _bfs() {
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				int nStep = point.step + 1;
				if( nx >= 0 && ny >= 0 && nx < row && ny < col && map[ny][nx] != -1 && !visited[ny][nx]) {
					q.add(new Point(nx, ny, nStep));
					visited[ny][nx] = true;
					map[ny][nx] = 1;
					result = nStep;
				}
			}
		}
		
	}
	
	static class Point{
		int x;
		int y;
		int step;
		Point(int x, int y, int step){
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	
}