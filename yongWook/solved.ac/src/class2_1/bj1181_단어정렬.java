package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());
		String[] arr = new String[t];
		
		for (int i = 0; i < t; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>()  {

			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else {
					return o1.length() - o2.length();
				}
				
			} 
		});
		
		
		for (int i = 0; i < arr.length; i++) {
			if( i >= 1 && !arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
			
			if( i == 0)
				System.out.println(arr[i]);
		}
		
	}
}
