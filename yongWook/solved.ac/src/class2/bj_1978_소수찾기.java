package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj_1978_�Ҽ�ã�� {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int inputArr[] = new int[N];
		
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 0; i < inputArr.length; i++) {
			if(check(inputArr[i]))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean check(int number) {
		
		if(number == 2 || number == 3 || number == 5 || number == 7) {
			return true;
		}
		if(number==1 || number == 0||number%2 == 0 || number%3 == 0 || number%5 == 0 || number%7 == 0) {
			return false;
		}
		else if(Math.sqrt(number) == Math.floor(Math.sqrt(number))   ) {
			System.out.println(Math.sqrt(number));
			System.out.println(Math.floor(Math.sqrt(number)));
			return false;
		}
		else {
			return true;
		}
	}
	
	////////////////////////////3�����϶� ����ó���ؾ���
}
