package class4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_12865_����ѹ賶 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //����� �� 
		int maxWeight = sc.nextInt(); //�ִ빫��
		
		PriorityQueue<BacPack> pq = new PriorityQueue<BacPack>();
		
		for (int i = 0; i < N; i++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			pq.add(new BacPack(weight, value));
		}
		
		int cumulativeWeight = 0;
		int dp[][] = new int[N][1];
		for (int i = 0; i < N; i++) {
			
			BacPack bacPack = pq.poll();
			int weight = bacPack.weight;
			int value = bacPack.value;
			
			if( weight <= maxWeight ) {
				if( cumulativeWeight + weight < maxWeight ) {
					dp[i][0] = 
				}
				else {
					
				}
			}
			
			//dp[i][0] = 
			
			
		}
		
	}
	
	
	static class BacPack  implements Comparable<BacPack>{
		int weight;// ����
		int value;// ��ġ
		
		BacPack(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
		@Override
		public int compareTo(BacPack o ) {
			return this.weight - o.weight;
		}
	}
}
