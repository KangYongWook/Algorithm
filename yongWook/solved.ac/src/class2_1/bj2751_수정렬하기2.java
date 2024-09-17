package class2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i));
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
		
	}
}
