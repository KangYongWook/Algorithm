package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2667_������ȣ���̱� {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		
		//�Է�
		int map[][] = new int[row][row];
		for (int i = 0; i < row; i++) {
			String input = br.readLine();
			for (int j = 0; j < row; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		boolean visited[][] = new boolean[row][row]; //�湮�迭
		Queue<int[]> q = new LinkedList<>(); //bfs
		
		int apartmentComplexCnt = 0; //��������
		ArrayList<Integer> apartmentCnt = new ArrayList<Integer>(); //������ ����Ʈ ����
		
		//��ü �� Ž��
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				
				//bfs
				if( visited[i][j] != true && map[i][j] == 1) { //�湮�Ǵ�
					
					visited[i][j] = true;
					q.add(new int[] {j,i});
					
					int cnt = 1;
					while(!q.isEmpty()) {
						int now[] = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = now[0] + dx[k];
							int y = now[1] + dy[k];
							if(x >= 0 && y >= 0 && x < row && y < row && visited[y][x] != true && map[y][x] != 0) {
								visited[y][x] = true;
								q.add(new int[] {x, y});
								cnt++;
							}
						}
					}
					apartmentCnt.add(cnt); //bfs���� ���� �־��ְ�
					apartmentComplexCnt++; //�������� ����
				}
			}
		}
		
		System.out.println(apartmentComplexCnt);
		Collections.sort(apartmentCnt);
		for (int i = 0; i < apartmentCnt.size(); i++) {
			System.out.println(apartmentCnt.get(i));
		}
		
	}
}
