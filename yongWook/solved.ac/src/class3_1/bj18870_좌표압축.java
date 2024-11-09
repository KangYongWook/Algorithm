package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj18870_좌표압축 {
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
			if(!hashMap.containsKey(unduplicationArr[i])) { //해당 조건을 안넣으면 뒤에 넣는애가 덮어씌움
				hashMap.put(unduplicationArr[i], index++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(hashMap.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
		
		//풀면서 느낌점.. 분명  2중포문 돌리면 터지는데.. 어떻게 해야하지........???????? set을 해도 이중포문이네 ??????? 
		//답안을 참고해보니 MAP을 사용했다...
		
		
		
	}
	
	
}
