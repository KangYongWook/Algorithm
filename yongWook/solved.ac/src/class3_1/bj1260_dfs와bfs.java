package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1260_dfs와bfs {
	
	static int[]  dx = {1,-1,0,0}; //동서남북
	static int[]  dy = {0,0,-1,1};
	static int map[][];
	static int visit[][];
	static int bfsVisit[][];
	static int N,M,K;
	static StringBuilder dfsSb = new StringBuilder();
	static StringBuilder bfsSb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		K = Integer.parseInt(st.nextToken()); //탐색 시작수
		map = new int[N+1][N+1];
		visit = new int[N+1][N+1];
		bfsVisit = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			String y = st.nextToken();
			map[Integer.parseInt(y)][Integer.parseInt(x)] = 1;
		}
		
		for (int i = 0; i < N+1; i++) {
			for (int j = K; j < N+1; j++) {
				if(map[i][j] == 1 && visit[i][j] != 1) {
					
					if(!dfsSb.toString().contains(String.valueOf(j))) {
						dfsSb.append(j+" ");
					}
					_dfs(i,j);
				}
			}
		}
		System.out.println(dfsSb.toString());
		
		for (int i = 0; i < N+1; i++) {
			for (int j = K; j < N+1; j++) {
				
				if(map[i][j] == 1 && bfsVisit[i][j] != 1) {
					
					if(!bfsSb.toString().contains(String.valueOf(j))) {
						bfsSb.append(j+" ");
					}
					_bfs(i,j);
				}
			}
		}
		System.out.println(bfsSb.toString());
	}
	
	//깊이우선탐색
	public static void _dfs(int y, int x) {
		visit[y][x] = 1;
		if(!dfsSb.toString().contains(String.valueOf(y))) {
			dfsSb.append(y+" ");
		}
		
		for (int i = 0; i < N+1; i++) {
			if( map[i][y] == 1 && visit[i][y] != 1) {
				_dfs(i,y);
			}
		}
	}
	
	//넓이우선탐색
	public static void _bfs(int y, int x) {
		bfsVisit[y][x] = 1;
		if(!bfsSb.toString().contains(String.valueOf(y))) {
			bfsSb.append(y+" ");
		}
	}
}
