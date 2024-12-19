package class3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7662_이중우선순위큐 {
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws Exception{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			
			int t2 = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			PriorityQueue<Integer> reverseQ = new PriorityQueue<Integer>(Comparator.reverseOrder());
			map = new HashMap<Integer, Integer>(); //숫자갯수 자료구조
			
			for (int j = 0; j < t2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				if(st.nextToken().equals("I")) {
					int number = Integer.parseInt(st.nextToken());
					q.add(number);
					reverseQ.add(number);
					map.put(number, map.get(number) == null ? 1 : map.get(number) + 1 );
				}
				else {
					//최대값제거
					if(st.nextToken().equals("1")) {
						
						if(map.size()==0) continue;
						delete(reverseQ);
					}
					//최소값 제거 
					else {
						if(map.size()==0) continue;

						delete(q);
					}
				}
			}
			
			//StringBuilder 
			if (map.isEmpty()) {
	            System.out.println("EMPTY");
	        } else {
	        	System.out.print(delete(reverseQ)+ " "); //max
	        	if(map.size()> 0) {
	        		System.out.print(delete(q)); //min
	        	}
	        	else {
	        		System.out.println();
	        	}
	        }
		}
	}
	
	
	static int delete(Queue<Integer> q) {
		int res = 0;
		while(true) {
			res = q.poll();
			
			int cnt = map.getOrDefault(res, 0);
			if(cnt ==0) continue;
			
			if(cnt ==1) {
				map.remove(res);
			}
			else {
				map.put(res, cnt-1);
			}
			
			
			break;
		}
		
		return res;
	}
}
