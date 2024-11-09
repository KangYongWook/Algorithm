package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111_����ũ����Ʈ {
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
					
					//���� ���ڰ� ���� ���� ���ں��� Ŭ��
					if(map[j][k] > i) {
						tempBlockCnt += map[j][k] - i; //���ֱ�
						tempTime +=  (map[j][k] - i) * 2 ; //�ð�����
					}
					
					//���� ���ڰ� ���� ���� ���ں��� ������
					else if(map[j][k] < i) {
						tempBlockCnt -= i-map[j][k]; //���ֱ�
						tempTime += i-map[j][k];//�ð�����
					}
				}
			}
			
			if(tempBlockCnt < 0) {
				continue;
			}
			
			if(resultTime > tempTime) { //�������� �ִ������� �������� ã������.
				resultTime = tempTime;
				resultBlock = i;
			}
		}
		
		System.out.println(resultTime + " " + resultBlock);
		
		
		//MIN MAX�� ã�°� �ٷ� �˾����� Ž���� ��� �Ұ������� ���� ����� �ߴ�..
		//MAP�� �������� �ؾ��ϳ�?? �ٸ��в� �����غ���.. MAP�� ������ �ƴ� MIN MAX�� ������ �����ϸ� �����ϴ�..
		
	}
}
