package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class bj11286_Àý´ë°ªÈü {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		PriorityQueue<int []> pq= new PriorityQueue<int[]>(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
				
			}
			
		});
		
		
		for (int i = 0; i < t; i++) {
			int input = Integer.parseInt(br.readLine());
			
			
			if(input > 0) {
				int temp[] = {input, 1};
				pq.add(temp);
			}else if(input < 0) {
				int temp[] = {Math.abs(input), -1};
				pq.add(temp);
			}else {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					int out[]  = pq.poll();
					if(out[1] > 0) {
						System.out.println(out[0]);
					}else {
						System.out.println(-out[0]);
					}
				}
			}
			
		}
	}
}
