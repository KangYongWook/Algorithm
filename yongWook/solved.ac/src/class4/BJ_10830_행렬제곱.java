package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10830_Çà·ÄÁ¦°ö {
	static int N;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		//ÀÔ·Â
		int map[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int returnMap[][] = new int[N][N];
		returnMap = map;
		for (int i = 0; i < B-1; i++) {
			
			returnMap = _calculate(map, returnMap);
			_print(returnMap);
		}
		
		
		
	}
	
	private static int[][] _calculate(int[][] originalMap, int[][] saveMap) {
		//Çà·Ä°ö¼À ±¸ÇÏ±â 
		int[][] returnMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int number = 0; 
				for (int k = 0; k < N; k++) {
					number += saveMap[i][k] * originalMap[k][j];
				}
				returnMap[i][j] = number%1000;
			}
		}
		return returnMap;
	}
	
	private static void _print(int[][] map) {
		//Ãâ·Â
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				
				if(j == map.length-1) {
					sb.append(map[i][j]);
				}
				else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
