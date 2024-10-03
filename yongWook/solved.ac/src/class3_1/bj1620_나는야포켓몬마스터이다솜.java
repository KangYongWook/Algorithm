package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //도감수
		int N = Integer.parseInt(st.nextToken()); //맞춰야하는 개수
		
		StringBuilder sb = new StringBuilder();
		
		
		//ArrayList<String> arr = new ArrayList<String>();
		Map< Integer, String> map = new HashMap<Integer, String>();
		Map< String, Integer > map1 = new HashMap< String, Integer>();
		
		//도감기록 
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			map.put(  i+1 ,  input );
			map1.put(  input ,  i+1 );
		}
		
		//도감탐색
		for (int i = 0; i < N; i++) {
			
			String input = br.readLine();
			
			try {
				sb.append( map.get( Integer.parseInt(input)) ).append("\n");
			} catch (Exception e) {
				sb.append( map1.get(input) ).append("\n");
//				int size = arr.size();
//				for (int j = 0; j < size; j++) {
//					if(arr.get(j).equals(input)){
//						sb.append( String.valueOf( j+1)  ).append("\n");
//					}
//				}
			}
		}
		
		System.out.println(sb);
		
		
	}
}
