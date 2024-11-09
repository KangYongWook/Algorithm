package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj30804_과일탕후루 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//과일숫자를 기록하는 배열
		int fruitCnt[] = new int[10]; 
		
		//입력
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fruit[] = new int[t];
		for (int i = 0; i < t; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
			fruitCnt[i]++;
		}
		
		int result = t; //과일의개수
		
		for (int i = 0; i < fruit.length; i++) {
			
			if(_checkFruitCnt(fruitCnt) <= 2) {
				break;
			}
			else {
				
			}
			
		}
		
	}
	
	//탐색 함수
	
	//과일 개수 확인 함수
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
