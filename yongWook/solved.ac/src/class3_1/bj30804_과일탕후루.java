package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj30804_�������ķ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//���ϼ��ڸ� ����ϴ� �迭
		int fruitCnt[] = new int[10]; 
		
		//�Է�
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fruit[] = new int[t];
		for (int i = 0; i < t; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
			fruitCnt[i]++;
		}
		
		int result = t; //�����ǰ���
		
		for (int i = 0; i < fruit.length; i++) {
			
			if(_checkFruitCnt(fruitCnt) <= 2) {
				break;
			}
			else {
				
			}
			
		}
		
	}
	
	//Ž�� �Լ�
	
	//���� ���� Ȯ�� �Լ�
	public static int _checkFruitCnt(int fruitCnt[]) {
		
		int result = 0;
		for (int i = 0; i < fruitCnt.length; i++) {
			if(fruitCnt[i] > 0) {
				result++;
			}
		}
		return result;
	}
}
