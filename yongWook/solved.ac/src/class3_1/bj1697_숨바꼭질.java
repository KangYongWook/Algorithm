package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697_���ٲ��� {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> q = new LinkedList<Point>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] memo = new boolean[2000000]; //�޸� �ʰ������� �޸������̼� �߰�
		
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
			if( tempX >=0 && !memo[tempX]) { //������������ �ʰ��Ѱ��� -1�Ҷ������ �ʿ���� �ش� ���� �ο�.
				memo[tempX] = true;
				q.add(new Point(tempX, point.depth+1));
			}
			
			
			//����2
			tempX = point.x + 1;
			if( tempX <= 200000 && !memo[tempX]) {
				memo[tempX] = true;
				q.add(new Point(tempX, point.depth+1));
			}
			
			//����3 �����̵�
			tempX = point.x * 2;
			if( tempX <= 200000 && !memo[tempX] ) {
				memo[tempX] = true;
				q.add(new Point( tempX, point.depth+1));
			}
		}
		
		System.out.println(result);
		
	}
	
	

	static class Point{
		
		int x;
		int depth;
		
		Point(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
		
		
	}
}
