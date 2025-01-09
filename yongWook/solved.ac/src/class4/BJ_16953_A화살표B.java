package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_16953_A»≠ªÏ«•B {
	static int result = 0;
	static long endNbr = 0;
	static Queue<Long> depQ;
	static Queue<Long> q ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long startNbr = sc.nextInt();
		endNbr = sc.nextInt();
		
		depQ = new LinkedList<Long>();
		q = new LinkedList<Long>();
		
		depQ.add(startNbr);
		while(true) {
			result++;
			q.addAll(depQ);
			depQ.clear();
			
			if(_bfs()) {
				break;
			}
			
			if(depQ.isEmpty()) {
				result = -1;
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	static boolean _bfs() {
		
		while (!q.isEmpty()) {
			Long now = q.poll();
			if(now * 2 == endNbr ) {
				result++;
				return true;
			}
			else if( Long.parseLong(String.valueOf(now) + "1") == endNbr) {
				result++;
				return true;
			}
			else {
				if( now * 2 < endNbr) {
					depQ.add( now * 2);
				}
				Long temp = Long.parseLong(String.valueOf(now) + "1");
				if( temp < endNbr) {
					depQ.add( temp );
				}
			}
		}
		return false;
	}
}
