package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj11651_��ǥ�����ϱ�2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int arr[][] = new int[t][2];
		StringTokenizer st ;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
//				else if(o1[1] >= 0 && o2[1] < 0) {
//					return o2[0] - o1[0];
//				}
//				else if(o1[0] < 0 && o2[0] >= 0) {
//					return o1[0] - o2[0];
//				}
//				else if(o1[0] < 0 && o2[0] < 0 ) {
//					if(o1[0] < o2[0]) {
//						return o2[0] - o1[0];
//					}else {
//						return o1[0] - o2[0];
//					}
//				}
				else {
					return o1[1] - o2[1];
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.println(sb);
		
	}
}
