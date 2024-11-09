package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj18870_��ǥ���� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int unduplicationArr[] = arr.clone();
		Arrays.sort(unduplicationArr);
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		int index = 0;
		for (int i = 0; i < unduplicationArr.length; i++) {
			if(!hashMap.containsKey(unduplicationArr[i])) { //�ش� ������ �ȳ����� �ڿ� �ִ¾ְ� �����
				hashMap.put(unduplicationArr[i], index++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(hashMap.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
		
		//Ǯ�鼭 ������.. �и�  2������ ������ �����µ�.. ��� �ؾ�����........???????? set�� �ص� ���������̳� ??????? 
		//����� �����غ��� MAP�� ����ߴ�...
		
		
		
	}
	
	
}
