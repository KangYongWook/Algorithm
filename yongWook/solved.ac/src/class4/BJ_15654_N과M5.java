package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654_N과M5 {

	static boolean visited[];
	static int N, M;
	static StringBuilder sb;
	static int arr[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		visited = new boolean[10000+1];
		sb = new StringBuilder();

		dfs(0);
	}

	public static void dfs(int depth) {

		if (depth == M) { // 고를수 있는수
			if (sb.length() > 0) {
				System.out.println(sb);
				return;
			}
		}

		for (int i : arr) {
			if(!visited[i]) {
				visited[i] = true;
				int beforeLength = sb.length();
				sb.append(i).append(" ");
				dfs(depth + 1);
				sb.deleteCharAt(sb.length() - 1); // 공백제거
				sb.delete(beforeLength, sb.length()); // 백트래킹 전에 넣었던 숫자 제거
				visited[i] = false;
			}
			
		}
			

	}
}
