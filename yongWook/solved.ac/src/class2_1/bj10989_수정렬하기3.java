package class2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10989_�������ϱ�3 {
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		//1.Arrays.sort - n~ n����
		//2.Collection.sort - n ~ nlogn
		//3.counting sort - ���ڿ����� ��밡���ϰ� ������ ���� ���� �ٸ� �޸𸮼Һ� ����
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
