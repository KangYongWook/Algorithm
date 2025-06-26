package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13549_���ٲ���3 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Point> q = new PriorityQueue<>((x, y) -> x.depth - y.depth);
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] memo = new boolean[2000000]; //�޸� �ʰ������� �޸������̼� �߰�
		int[] depthMemo = new int[2000000]; //�޸� �ʰ������� �޸������̼� �߰� --> ������ �����ϱ⶧���� �����ص��Ǳ���. 
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//������ ���� ��ġ�� ������ �ٷ� ������
		if(n  >= k ) {
			System.out.println(n-k);
			return;
		}
		
		int result = 0;
		//�Է�
		q.add(new Point( n, 0));
		while(!q.isEmpty()) {
			
			Point point = q.poll();
			if( point.x == k ) {
				result = point.depth;
				break;
			}
			
			//����1
			int tempX = point.x -1;
			int depth = point.depth + 1  ;
			if( tempX >= 0 && (!memo[tempX] || (memo[tempX] && depthMemo[tempX] > depth ))) { //�湮�� ���߰ų�, �湮�߾ depth�� ���� �� ������ q�� ����.
				memo[tempX] = true;
				depthMemo[tempX] = depth;
				q.add(new Point(tempX, depth));
			}
			
			
			//����2
			tempX = point.x + 1;
			if( tempX <= 200000 && (!memo[tempX] || (memo[tempX] && depthMemo[tempX] > depth ))) {
				memo[tempX] = true;
				depthMemo[tempX] = depth;
				q.add(new Point(tempX, depth));
			}
			
			//����3 �����̵�
			tempX = point.x * 2;
			depth = point.depth;
			if( tempX <= 200000 && (!memo[tempX] || (memo[tempX] && depthMemo[tempX] > depth )))  {
				memo[tempX] = true;
				depthMemo[tempX] = depth;
				q.add(new Point( tempX, depth));
			}
		}
		
		System.out.println(result);
		
	}
	
	

	static class Point {
		
		int x;
		int depth;
		
		Point(int x, int depth){
			this.x = x;
			this.depth = depth;
		}

		
	}
}
