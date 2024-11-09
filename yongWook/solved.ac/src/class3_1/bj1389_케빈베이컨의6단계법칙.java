package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1389_케빈베이컨의6단계법칙 {

	static List<Integer>[] arr;
	static int[] memo;
	static boolean[] check;
	static int answer;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		memo = new int[n+1];
		arr = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				answer= Integer.MAX_VALUE; 
				check = new boolean[n+1];
				if(i!=j) {
					dfs(i,j,0);
					memo[i] += answer;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int idx =0;
		for(int i=1; i<n+1; i++) {
			if(min > memo[i]) {
				min = memo[i];
				idx =i;
			}
		}
		System.out.println(idx);
		
		
	}
	
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		check[start] = true;
		for(int i=0; i<arr[start].size(); i++) {
			int next = arr[start].get(i);
			if(!check[next]) {
				dfs(next,end, cnt+1);
			}
		}
		check[start]=false;
	}
}
