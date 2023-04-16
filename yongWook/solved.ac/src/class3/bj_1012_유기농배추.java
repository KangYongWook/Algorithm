package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1012_유기농배추 {
	
	static boolean visit[][] ;
	static int arr[][] ;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static int N ;
	static int M ;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < repeat; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //세로길이
			M = Integer.parseInt(st.nextToken()); //가로길이
			int K = Integer.parseInt(st.nextToken()); //배추심는곳
			
			arr = new int[N][M];
			visit = new boolean[N][M];
			
			int result = 0;
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				arr[p1][p2] = 1;
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (arr[x][y] == 1 && !visit[x][y]) {
						dfs(x, y);
						result++;
					}
				}
			}

			System.out.println(result);
		}
		
		
	}
	
	public static void dfs(int y, int x) {
		visit[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visit[cy][cx] && arr[cy][cx] == 1) {
					dfs(cy, cx);
				}
			}

		}

	}

	
	
}
