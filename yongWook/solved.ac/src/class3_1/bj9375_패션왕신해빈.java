package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class bj9375_패션왕신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine()); //의상수
			String arr[][] = new String[n][2];
			ArrayList<String> distnctArr = new ArrayList<String>();
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = st.nextToken();
				
				String kindclothes = st.nextToken(); //의상종류
				arr[j][1] = kindclothes;
				distnctArr.add(kindclothes);
				
				if(map.get(kindclothes) == null) {
					map.put(kindclothes, 1);
				}else {
					map.put(kindclothes, map.get(kindclothes) + 1);
				}
				
			}
			
			distnctArr = (ArrayList<String>) distnctArr.stream().distinct().collect(Collectors.toList());
			
			int result = 0;
			for (int j = 2; j <= distnctArr.size(); j++) {
				result += _combination(distnctArr.size(), j);
			}
			 
			for (int j = 0; j < map.size(); j++) {
				result = result * map.get(distnctArr.get(j));
			}
			
			System.out.println(result + arr.length);
			
		}
		
	}
	public static int _combination(int number, int number1) {
		return _factorial(number) / (_factorial(number - number1) *_factorial(number1) );
	}
	
	public static int _factorial(int number) {
		
		int result = 1;
		for (int i = 1; i <= number; i++) {
			result *= i ;
		}
		return result;
	}
}
