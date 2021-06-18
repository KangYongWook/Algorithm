package class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2164_Ä«µå2 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		int temp =0;
		while(q.size() != 1) {
			
			q.poll();
			temp = q.poll();
			q.add(temp);
		}
		
		
		System.out.println(q.poll());
	}
}
