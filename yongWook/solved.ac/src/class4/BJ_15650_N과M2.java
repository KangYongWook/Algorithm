package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N과M2 {

	static boolean visited[];
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		sb = new StringBuilder();

		dfs(1,0);
	}

	public static void dfs(int start, int depth) {

		if (depth == M) { // 고를수 있는수
			if (sb.length() > 0) {
				System.out.println(sb);
				return;
			}
		}

		for (int i = start; i <= N; i++) {
			sb.append(i).append(" ");
			dfs(i+1, depth + 1);
			sb.deleteCharAt(sb.length() - 1); // 공백제거
			sb.deleteCharAt(sb.length() - 1); // 백트래킹 전에 넣었던 숫자 제거
			
		}

	}
}
