package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1012_��������_1 {
	static int[]  dx = {1,-1,0,0}; //��������
	static int[]  dy = {0,0,-1,1};
	static int map[][];
	static int visit[][];
	
	static int M,N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //���α���
			N = Integer.parseInt(st.nextToken()); //���α���
			K = Integer.parseInt(st.nextToken()); //���� ���� ����
			map = new int[N][M];
			visit = new int[N][M];
			for (int j = 0; j < K; j++) { //��ǥ �ۼ�
				st = new StringTokenizer(br.readLine());
				String x = st.nextToken();
				String y = st.nextToken();
				map[Integer.parseInt(y)][Integer.parseInt(x)] = 1;
			}
			
			int result = 0;
			//dfsŽ��
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < M; z++) {
					
					if(map[j][z] == 1 && visit[j][z] != 1) {
						result++;
						_dfs(j, z);
					}
					
				}
			}
			System.out.println(result);
		}
		
	}
	
	//���̿켱Ž��
	public static void _dfs(int y, int x) {
		visit[y][x] = 1;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if( xx >= 0 && xx < M && yy < N && yy >= 0 && map[yy][xx] == 1&& visit[yy][xx] != 1) {
				_dfs(yy,xx);
			}
		}
	}

}
