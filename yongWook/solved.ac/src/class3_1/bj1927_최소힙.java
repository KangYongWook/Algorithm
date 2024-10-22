package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1927_√÷º“»¸ {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(); 
		for (int i = 0; i < t; i++) {
			
			int input =  Integer.parseInt(br.readLine());
			
			if(input == 0 ) {
				
				if(q.isEmpty()) {
					System.out.println(0);
				}
				else{
					System.out.println(q.poll());
				}
			}
			else{
				q.add(input);
			}
		}
	}
}
