package class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_15663_N과M9 {

	static int visited[];
	static int N, M;
	static StringBuilder sb;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		
		visited = new int[10000+1];
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
		int currenNbr = -1;
		for (int i : arr) {
				visited[i]++;
				int now = i;
				if( visited[i] <= arr.stream().filter( o -> o == i).count() && currenNbr != now) {
					currenNbr = now;
					int beforeLength = sb.length();
					sb.append(i).append(" ");
					dfs(depth + 1);
					sb.deleteCharAt(sb.length() - 1); // 공백제거
					sb.delete(beforeLength, sb.length()); // 백트래킹 전에 넣었던 숫자 제거
				}
				visited[i]--;
		}
	}
}
