package class2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10989_수정렬하기3 {
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		//1.Arrays.sort - n~ n제곱
		//2.Collection.sort - n ~ nlogn
		//3.counting sort - 숫자에서만 사용가능하고 성능이 가장 좋다 다만 메모리소비가 심함
		int t = Integer.parseInt(br.readLine());
		
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			sb.append("\n");
		}
		System.out.println(sb);*/
		
		int t = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		for (int i = 0; i < t; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			while(true) {
				if(arr[i] != 0) {
					sb.append(i);
					sb.append("\n");
					arr[i]--;
				}else {
					break;
				}
			}
		}
		System.out.println(sb);
		
	}
}
