package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15666_N과M12 {

	static boolean visited[];
	static int N, M;
	static StringBuilder sb;
	static StringBuilder printSb;
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
		printSb = new StringBuilder();

		dfs(0);
		
		System.out.println(printSb);
	}

	public static void dfs(int depth) {

		if (depth == M) { // 고를수 있는수
			if (sb.length() > 0) {
				//if(!printSb.toString().contains(sb.toString())) {
					printSb.append(sb).append("\n");
				//}
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			int beforeLength = sb.length();
			sb.append(arr[i]).append(" ");
			dfs(depth + 1);
			sb.deleteCharAt(sb.length() - 1); // 공백제거
			sb.delete(beforeLength, sb.length()); // 백트래킹 전에 넣었던 숫자 제거
			
		}
		


	}
}
