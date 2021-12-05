package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2805_나무자르기 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int treeArr[] = new int[N];
		st = new StringTokenizer(br.readLine());

		int max = 0;
		for (int i = 0; i < treeArr.length; i++) {
			treeArr[i] = Integer.parseInt(st.nextToken());
			if (max < treeArr[i]) {
				max = treeArr[i];
			}
		}

		int startCut = max;
		int result = 0;
		
		int min = max - M ;
		while (true) {
			result = 0;
			for (int i = 0; i < treeArr.length; i++) {
				if (treeArr[i] - startCut >= 0) {
					result += treeArr[i] - startCut;

				}
			}
			asdsadad
			

			if (result >= M) {
				System.out.println(startCut);
				break;
			}else {
				startCut --;
			}
			
		}
		
	}
}
