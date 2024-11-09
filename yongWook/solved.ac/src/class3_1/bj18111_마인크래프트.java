package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int blockCnt = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[col][row];
		
		int minNbr = Integer.MAX_VALUE;
		int maxNbr = 0; 
		int resultTime = Integer.MAX_VALUE; 
		int resultBlock = 0;
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minNbr = Math.min(minNbr,map[i][j]);
				maxNbr = Math.max(maxNbr,map[i][j]);
			}
		}
		
		
		int tempBlockCnt = 0;
		int tempTime = 0;
		for (int i = minNbr; i <= maxNbr; i++) {
			
			tempBlockCnt = blockCnt; 
			tempTime = 0;
			for (int j = 0; j < col; j++) {
				for (int k = 0; k < row; k++) {
					
					//현재 숫자가 제일 작은 숫자보다 클때
					if(map[j][k] > i) {
						tempBlockCnt += map[j][k] - i; //블럭넣기
						tempTime +=  (map[j][k] - i) * 2 ; //시간셋팅
					}
					
					//현재 숫자가 제일 작은 숫자보다 작을때
					else if(map[j][k] < i) {
						tempBlockCnt -= i-map[j][k]; //블럭넣기
						tempTime += i-map[j][k];//시간셋팅
					}
				}
			}
			
			if(tempBlockCnt < 0) {
				continue;
			}
			
			if(resultTime > tempTime) { //같을때도 넣는이유는 높은땅을 찾기위함.
				resultTime = tempTime;
				resultBlock = i;
			}
		}
		
		System.out.println(resultTime + " " + resultBlock);
		
		
		//MIN MAX를 찾는건 바로 알았으나 탐색을 어떻게 할것인지에 대한 고민을 했다..
		//MAP을 기준으로 해야하나?? 다른분껄 참고해보니.. MAP이 기준이 아닌 MIN MAX로 기준을 생각하면 간단하다..
		
	}
}
