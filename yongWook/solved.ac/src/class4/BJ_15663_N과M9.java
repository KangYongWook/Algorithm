package class4;
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
=======

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
>>>>>>> 993f58cd7671d0113151f144a4d9dadff9c713a7
import java.util.StringTokenizer;

public class BJ_15663_N과M9 {

<<<<<<< HEAD
	static boolean visited[];
	static int N, M;
	static StringBuilder sb;
	static StringBuilder printSb;
	static int arr[];
=======
	static int visited[];
	static int N, M;
	static StringBuilder sb;
	static ArrayList<Integer> arr;
>>>>>>> 993f58cd7671d0113151f144a4d9dadff9c713a7

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
<<<<<<< HEAD
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
=======
		arr = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		
		visited = new int[10000+1];
		sb = new StringBuilder();

		dfs(0);
		
>>>>>>> 993f58cd7671d0113151f144a4d9dadff9c713a7
	}

	public static void dfs(int depth) {

		if (depth == M) { // 고를수 있는수
			if (sb.length() > 0) {
<<<<<<< HEAD
				if(!printSb.toString().contains(sb.toString())) {
					printSb.append(sb).append("\n");
				}
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
			

=======
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
>>>>>>> 993f58cd7671d0113151f144a4d9dadff9c713a7
	}
}
