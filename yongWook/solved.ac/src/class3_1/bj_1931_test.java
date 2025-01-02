package class3_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class bj_1931_test {
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		List<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		System.out.println(stack.get(0));
		
		/*
		  time[][0] �� ���۽����� �ǹ� 
		  time[][1] �� ��������� �ǹ� 
		*/
		int[][] time = new int[N][2];
		
		
		for(int i = 0; i < N; i++) {
			time[i][0] = in.nextInt();	// ���۽ð� 
			time[i][1] = in.nextInt();	// ����ð� 
		}
		
		
		// ������ �ð��� �������� �����ϱ� ���� compare ������ 
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// ����ð��� ���� ��� ���۽ð��� ���������� �����ؾ��Ѵ�.  
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(time[i][j]);
			}
			System.out.println();
		}
		
		
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// ���� ����ð��� ���� ȸ�� ���� �ð����� �۰ų� ���ٸ� ���� 
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
}
