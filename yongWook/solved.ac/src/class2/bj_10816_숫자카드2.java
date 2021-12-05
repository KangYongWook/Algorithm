package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
asdsad
public class bj_10816_숫자카드2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer stN = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer stM = new StringTokenizer(br.readLine());

		List<Integer> arrN = new ArrayList<Integer>();
		List<Integer> arrM = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			arrN.add(Integer.parseInt(stN.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			arrM.add(Integer.parseInt(stM.nextToken()));
		}

		Collections.sort(arrN);

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < arrM.size(); i++) {
			result.add(check(arrN, arrM.get(i)));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			if (i == result.size() - 1) {
				sb.append(   result.get(i)       );
			} else {
				sb.append(   result.get(i)  + " "    );
			}
		
		}
		System.out.println(sb);

	}
	public static int check(List<Integer> arrN, int number) {

		int result = 0;
		int min = 0;
		int max = arrN.size();
		int middle = (max+min)/2; 
		//이분탐색
		while(true) {
			
			if(arrN.get(middle) > number) {
				max = middle;
				middle = (max+min)/2;
			}else if(arrN.get(middle) < number){
				min = middle+1;
				middle = (max+min)/2;
			}else {
				int index = middle;
				while(true) {
					if(index<= arrN.size()-1 && arrN.get(index) == number  ) {
						result++;
						index++;
					}else {
						break;
					}
				}
				index = middle-1;
				while(true) {
					if( index>= 0 && arrN.get(index) == number  ) {
						result++;
						index--;
					}else {
						break;
					}
				}
				break;
			}
			
			if(middle == max) {
				break;
			}
		}

		return result;
	}
}
