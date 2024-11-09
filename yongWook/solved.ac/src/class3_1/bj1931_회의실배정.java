package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj1931_회의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int cabinet[][] = new int[t][2];
		
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				cabinet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//첫번째 숫자 두번째숫자 정렬
		Arrays.sort(cabinet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
			}
		});
		
		
		int startTime = 0;
		int result = 0;
		for (int i = 0; i < t; i++) {
			
//			//회의실 기준시간
//			if(startTime > cabinet[i][0]) {
//				continue;
//			}
//			//마지막 배열일때 
//			if(i == t-1 ) {
//				result++;
//				break;
//			}
//			
//			//앞의 숫자의 뒤에숫자가 그다음숫자의 앞에숫자보다 클때
//			if(cabinet[i][1] > cabinet[i+1][0]) {
//				if(cabinet[i][1] > cabinet[i+1][1] ) { // 그다음숫자도 작아
//					continue;
//				}
//				else {
//					startTime = cabinet[i][1];
//					//System.out.println(startTime);
//					result++;
//				}
//			}
//			else {
//				startTime = cabinet[i][1];
//				//System.out.println(startTime);
//				result++;
//			}
			
			if(startTime <= cabinet[i][0]) {
				startTime = cabinet[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}
}
