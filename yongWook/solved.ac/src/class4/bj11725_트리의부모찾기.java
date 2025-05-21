package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11725_트리의부모찾기 {
	
	static int result[];
	static boolean visited[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		
		list = new ArrayList[N+1];
		result = new int[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
	    }
		 
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		//정점이 1부터시작
		_dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
		
		
	}
	
	private static void _dfs(int start) {
		visited[start] = true;
		for (int to : list[start]) {
		    if (!visited[to]) {
		    	result[to] = start;
		       _dfs(to);
		    }
		}
	}
	
	
}
