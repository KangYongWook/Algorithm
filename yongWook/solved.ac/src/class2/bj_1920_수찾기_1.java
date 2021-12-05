package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj_1920_¼öÃ£±â_1 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int inputArr[] = new int[N];
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int compareArr[] = new int[M];
		for (int i = 0; i < inputArr.length; i++) {
			compareArr[i] = Integer.parseInt(st.nextToken());
		}
		
		compare(inputArr, compareArr);
		
		
	}
	
	private static void compare(int inputArr[], int compareArr[]) {
		
		int min = 0;
		int max = 
		
		for (int i = 0; i < inputArr.length; i++) {
			
		}
	}
}
