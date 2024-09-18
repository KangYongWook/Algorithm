package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int maxNbr = 0 ;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxNbr = Math.max(maxNbr, arr[i]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			stack.add(i);
			sb.append("+\n");
			
			while(!stack.isEmpty()) {
				if(stack.peek() == arr[cnt]) {
					stack.pop();
					cnt++;
					sb.append("-\n");
				}
				else {
					break;
				}
			}
			
			if(stack.isEmpty() && arr.length <= cnt) {
				break;
			}
			
			if(maxNbr < i ) {
				break;
			}
		}
		
		if(stack.isEmpty() && arr.length <= cnt) {
			System.out.println(sb);
			
		}
		else {
			System.out.println("NO");
		}
		
		
	}
}
