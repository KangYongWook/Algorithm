package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mapSize = Integer.parseInt(st.nextToken());
		int sumCnt = Integer.parseInt(st.nextToken());
		
		//맵 입력
		int map[][] = new int[mapSize][mapSize];
		//누적합 맵
		int cumulativeSum[][] = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					if(j == 0) {
						cumulativeSum[i][j] = map[i][j];
					}else {
						cumulativeSum[i][j] = cumulativeSum[i][j-1] + map[i][j];
					}
				}else {
					if(j == 0) {
						cumulativeSum[i][j] = cumulativeSum[i-1][j] + map[i][j];
					}else {
						cumulativeSum[i][j] = cumulativeSum[i-1][j] + cumulativeSum[i][j-1] - cumulativeSum[i-1][j-1] + map[i][j];
					}
					
				}
				  
			}
		}
		
		//좌표입력
		int coordinate[][] = new int[sumCnt][4];
		for (int i = 0; i < sumCnt; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				coordinate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		
//		for (int i = 0; i < mapSize; i++) {
//			for (int j = 0; j < mapSize; j++) {
//				System.out.print(cumulativeSum[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sumCnt; i++) {
			int x1 = coordinate[i][0]-1;
			int y1 = coordinate[i][1]-1;
			int x2 = coordinate[i][2]-1;
			int y2 = coordinate[i][3]-1;
			
			int result = cumulativeSum[x2][y2];
			if(x1 != 0) {
				result -= cumulativeSum[x1-1][y2]; //x축
			}
			if(y1 != 0) {
				result -= cumulativeSum[x2][y1-1]; //y축
			}
			if(x1 != 0 && y1 != 0) {
				result += cumulativeSum[x1-1][y1-1]; //겹치는 부분
			}
			sb.append(result).append("\n");
			//System.out.println(result);
		}
		System.out.println(sb.toString());
	}
}
