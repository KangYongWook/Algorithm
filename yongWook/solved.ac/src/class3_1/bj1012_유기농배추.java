package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1012_유기농배추 {
	static int map[][];
	static int visit[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = 0;
			
			M = Integer.parseInt(st.nextToken());//가로길이
			N = Integer.parseInt(st.nextToken());//세로길이
			int k = Integer.parseInt(st.nextToken());//배추위치
			
			map = new int[N][M];
			visit = new int[N][M];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken()); 
				map[y][x] = 1;
			}
			
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if( map[y][x] == 1 && visit[y][x] != 1) {
						_dfs(y, x);
						result++;
					}
				}
			}
			
			
			System.out.println(result);
		}
		/*
		0 0
		0 1
		2 4
		4 2
		4 7
		5 4*/
		
	}
	
	public static void _dfs(int y , int x) {
		visit[y][x] = 1;
		
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx>=0 && cy>=0 && cx < M && cy < N ) {
				if( map[cy][cx] == 1 && visit[cy][cx] != 1) {
					_dfs(cy, cx);
				}
			}
		}
		
	}
	
	public static void _dfs(int y, int x ) {
		visit[y][x] =1;
		
		for (int i = 0; i < dx.length; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if() {
				if(map[cy][cx] == 1 && visit[cy][cy] != 1) {
					_dfs(cy,cx);
			}
		}
		
	}
	}
}
