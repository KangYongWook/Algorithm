package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj_1920_수찾기 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int map[] = new int[N];
		for (int i = 0; i < map.length; i++) {
			map[i]= Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int findNumber[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < findNumber.length; i++) {
			findNumber[i]= Integer.parseInt(st.nextToken());
		}

		//조건
		Arrays.sort(map);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < findNumber.length; i++) {		
			sb.append(check(map,findNumber[i]));			
		}
		System.out.println(sb.toString());
			
	}
	public static String check(int map[] ,int number) {
		
		int min =0;
		int max = map.length;
		int middle = (min + max)/2;
		while(true) {
			
			
			if(map[middle] == number) { //같을떄
				return "1\n";
				
			}else if(map[middle] > number ){ //작을떄
				if(middle <= min || middle >= max) {
					return "0\n";
				}
				max = middle;
				middle = (max + min)/2 ;
			}else { //클때
				if(middle <= min || middle >= max) {
					return "0\n";
				}
				min = middle;
				middle = (min + max)/2 ; 
				
			}
		}
		
	}
	
}
