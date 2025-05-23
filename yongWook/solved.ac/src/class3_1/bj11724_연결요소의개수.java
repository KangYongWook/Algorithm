package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11724_연결요소의개수 {
	
	static boolean visited[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
	    }
		 
		 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		int result = 0;
		//정점이 1부터시작
		for (int i = 1; i <= N; i++) {
		     if (!visited[i]) {
		         _dfs(i);
		         result++;
		     }
		}
		
		System.out.println(result);
		
	}
	
	
	private static void _dfs(int start) {
		visited[start] = true;
		for (int to : list[start]) {
		    if (!visited[to]) {
		       _dfs(to);
		    }
		}
	}
}
