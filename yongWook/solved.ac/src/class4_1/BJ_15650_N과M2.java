package class4_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N°úM2 {

	static int N, M;
	static int depthArr[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		depthArr = new int[M];
		

		dfs(1,0);
	}

	public static void dfs(int start, int depth) {
		
		if(depth == M) {
			sb = new StringBuilder();
			for (int i = 0; i < depthArr.length; i++) {
				sb.append(depthArr[i]+" ");
			}
			System.out.println(sb);
			return;
		}
		
		for (int i = start; i <= N; i++) {
			depthArr[depth] = i;
			dfs(i+1, depth + 1);
		}
		
		
		
	}
}
