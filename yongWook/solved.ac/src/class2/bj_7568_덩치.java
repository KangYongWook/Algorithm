package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_7568_µ¢Ä¡ {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		StringTokenizer st;
		ArrayList<Integer> rank = new ArrayList<Integer>();
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					cnt++;
				}
				
			}
			rank.add(cnt);
			cnt = 1;
		}

		for (int i = 0; i < rank.size(); i++) {
			System.out.print(rank.get(i)+" ");
		}
	}
}
