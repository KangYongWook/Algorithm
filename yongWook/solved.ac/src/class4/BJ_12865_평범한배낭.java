package class4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_12865_평범한배낭 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //경우의 수 
		int maxWeight = sc.nextInt(); //최대무게
		
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
		int weight;// 무게
		int value;// 가치
		
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
