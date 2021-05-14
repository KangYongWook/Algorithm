package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class bj_1181_단어정렬 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]= br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
			if(o1.length()==o2.length()) {
				return o1.compareTo(o2);
			}
				return o1.length()-o2.length();
			}
		
		});
		
		for (int i = 0; i < arr.length; i++) {
			if( i>=1 && arr[i].equals(arr[i-1])){
				continue;
			}
			System.out.println(arr[i]);
		}
		
		
	}
}
