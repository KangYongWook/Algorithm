package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178_미로탐색 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[col][row];
		//입력
		for (int i = 0; i < col; i++) {
			String input = br.readLine(); 
			for (int j = 0; j < row; j++) {
				map[i][j] = input.charAt(j) - '0'; 
			}
		}
		
		boolean visited[][] = new boolean[col][row];
		visited[0][0] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		
		//bfs
		OUTER:
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if(x >= 0 && y >= 0 && x < row && y < col && visited[y][x] != true && map[y][x] != 0) {
					visited[y][x] = true;
					q.add(new int[] {x, y});
					map[y][x] = map[now[1]][now[0]] + 1;
					
					if( y== col && x == row) {
						break OUTER;
					}
				}
			}
		}
		
		System.out.println(map[col-1][row-1]);
		
	}
}
