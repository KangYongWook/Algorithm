package class2;

import java.util.Scanner;

/**
 * 
 * ���� : �ܾ�����  �ܾ ª���ź��� ����
 * �ۼ��� : �����
 * ���� : 
 */
public class bj_1436_��ȭ������_1 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int cnt = 0 ;
		for (int i = 666; i < Integer.MAX_VALUE; i++) {
			if(Integer.toString(i).contains("666")) {	
				
				arr[cnt] = i;
				cnt++;
				if(cnt == N)
					break;
			}
		}
		System.out.println(arr[N-1]);
		
	}
}
