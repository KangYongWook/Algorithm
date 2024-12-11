package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14940_�����ִܰŸ� {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //����
		int M = Integer.parseInt(st.nextToken()); //����
		
		int map[][] = new int[N][M];
		int resultMap[][] = new int[N][M];
		boolean visited[][] = new boolean[N][M];
		int startX = 0;
		int startY = 0;
		//�Է�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) { //��ŸƮ ��ġ ����ϴ°�
					 startY = i;
	                 startX = j;
                }
				else if(map[i][j] == 0) { // �湮�迭�� ���� true
					visited[i][j] = true;
				}
			} 
		}
		
		//bfs
		Queue<int[]> q = new LinkedList<>();
		visited[startY][startX] = true;
		q.add(new int[] {startY,startX});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = now[1] + dx[i];
				int y = now[0] + dy[i];
				if(x >= 0 && y >= 0 && x < M && y < N && visited[y][x] != true  && map[y][x] == 1) {
					visited[y][x] = true;
					resultMap[y][x] = resultMap[now[0]][now[1]] + 1;
					q.add(new int[] {y, x});
				}
			}
			
			
		}
		
		
		
		
		
		
		
		//��ü �� Ž��
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					System.out.print(-1+" ");
				}else {
					System.out.print(resultMap[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
	}
}
