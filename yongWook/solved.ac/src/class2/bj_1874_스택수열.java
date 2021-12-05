package class2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class bj_1874_스택수열 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int index = 0;
		int cnt= 1;
		
		while(true){
			if(stack.size() == 0) {
				stack.add(cnt);
				sb.append("+\n");
				cnt++;
			}
			else if(stack.size() != 0) {
				if(stack.peek() == arr[index]) {
					stack.pop();
					index++;
					sb.append("-\n");
					
					if(stack.size() ==0 && cnt >= N || index == N)
						break;
				}else {
					stack.add(cnt);
					sb.append("+\n");
					cnt++;
				}
				
			}
			
			if(cnt > N +1) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		
		System.out.println(sb);
		
		
	}
}
