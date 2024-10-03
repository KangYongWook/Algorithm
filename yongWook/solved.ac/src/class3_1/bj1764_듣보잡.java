package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<Integer, String > map1 = new HashMap<Integer, String>();
		
		ArrayList<String> resultArr = new ArrayList<String>(); 
		//듣도못한사람
		for (int i = 0; i < N; i++) {
			map.put( br.readLine(), i );
		}
		
		//보도못한사람
		for (int i = 0; i < M; i++) {
			map1.put( i, br.readLine() );
		}
		
		
		for (int i = 0; i < N; i++) {
			
			if( map.get( map1.get(i) ) != null ) {
				resultArr.add( map1.get(i));
			}
		}
		
		Collections.sort(resultArr);
		
		System.out.println(resultArr.size());
		for (int i = 0; i < resultArr.size(); i++) {
			System.out.println(resultArr.get(i));
		}
		
		
		
	}
}
